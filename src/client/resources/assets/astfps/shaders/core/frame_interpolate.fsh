#version 330
#extension GL_ARB_separate_shader_objects : require

uniform sampler2D PreviousSampler;
uniform sampler2D CurrentSampler;
uniform sampler2D PreviousDepthSampler;
uniform sampler2D CurrentDepthSampler;

layout(location = 0) in vec2 texCoord;
layout(location = 0) out vec4 fragColor;

void main() {
    vec2 texel = 1.0 / vec2(textureSize(CurrentSampler, 0));
    vec3 centerPrevious = texture(PreviousSampler, texCoord).rgb;
    vec2 bestOffset = vec2(0.0);
    float bestError = 1e20;

    // Compile-time radius: 3x3 on constrained hardware, 5x5 with sustained headroom.
    for (int y = -ASTFPS_RADIUS; y <= ASTFPS_RADIUS; ++y) {
        for (int x = -ASTFPS_RADIUS; x <= ASTFPS_RADIUS; ++x) {
            vec2 offset = vec2(x, y) * texel;
            vec3 candidate = texture(CurrentSampler, texCoord + offset).rgb;
            vec3 difference = centerPrevious - candidate;
            float error = dot(difference, difference);
            if (error < bestError) {
                bestError = error;
                bestOffset = offset;
            }
        }
    }

    vec4 warpedPrevious = texture(PreviousSampler, texCoord - bestOffset * ASTFPS_WEIGHT);
    vec4 warpedCurrent = texture(CurrentSampler, texCoord + bestOffset * (1.0 - ASTFPS_WEIGHT));
    // Reject aggressive warping around disocclusions and flashes where correspondence is weak.
    float previousDepth = texture(PreviousDepthSampler, texCoord - bestOffset * ASTFPS_WEIGHT).r;
    float currentDepth = texture(CurrentDepthSampler, texCoord + bestOffset * (1.0 - ASTFPS_WEIGHT)).r;
    float centerDepthDelta = abs(texture(PreviousDepthSampler, texCoord).r
        - texture(CurrentDepthSampler, texCoord).r);
    float warpedDepthDelta = abs(previousDepth - currentDepth);
    float colorConfidence = 1.0 - smoothstep(0.035, 0.30, bestError);
    // Relative thresholds stay projection-agnostic and reject foreground/background crossings.
    float depthScale = max(1e-5, min(abs(previousDepth), abs(currentDepth)));
    float depthConfidence = 1.0 - smoothstep(0.0025, 0.035,
        max(centerDepthDelta, warpedDepthDelta) / depthScale);
    float confidence = colorConfidence * depthConfidence;
    // Disoccluded pixels have no valid temporal correspondence. Prefer the current
    // real frame there; blending an absent foreground sample creates black flashes.
    vec4 currentColor = texture(CurrentSampler, texCoord);
    fragColor = mix(currentColor, mix(warpedPrevious, warpedCurrent, ASTFPS_WEIGHT), confidence);
}
