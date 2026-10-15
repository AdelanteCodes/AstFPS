package dev.adelantecodes.astfps.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/** Strict JSON reports: unavailable floating-point telemetry is emitted as null, never NaN. */
final class SafeJson {
    private SafeJson() { }

    static Gson pretty() {
        TypeAdapter<Double> finiteDouble = new TypeAdapter<>() {
            @Override public void write(JsonWriter output, Double value) throws IOException {
                if (value == null || !Double.isFinite(value)) output.nullValue();
                else output.value(value);
            }

            @Override public Double read(JsonReader input) throws IOException {
                if (input.peek() == JsonToken.NULL) {
                    input.nextNull();
                    return null;
                }
                return input.nextDouble();
            }
        };
        return new GsonBuilder()
            .registerTypeAdapter(double.class, finiteDouble)
            .registerTypeAdapter(Double.class, finiteDouble)
            .setPrettyPrinting()
            .create();
    }
}
