package dev.adelantecodes.astfps.client.resources;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/** Bounded negative lookups for one immutable, open native ZIP handle; owns no archive resources. */
public final class ZipEntryMissCache {
    private static final int MAX_MISSES = 128;
    private static final int MAX_PATH_LENGTH = 1024;
    private final LinkedHashMap<String, Boolean> misses = new LinkedHashMap<>();
    private WeakReference<ZipFile> archive = new WeakReference<>(null);
    private long generation;

    public ZipEntry lookup(ZipFile zip, String path) {
        // In particular, null must reach native getEntry and retain its exception semantics.
        if (zip == null || zip.getClass() != ZipFile.class || path == null
                || path.length() > MAX_PATH_LENGTH) {
            return zip.getEntry(path);
        }
        long observedGeneration;
        synchronized (this) {
            if (archive.get() != zip) {
                clear();
                archive = new WeakReference<>(zip);
            }
            if (misses.containsKey(path)) {
                // Native getEntry rejects closed handles even when the requested name is missing.
                zip.size();
                return null;
            }
            observedGeneration = generation;
        }

        // Never hold the cache monitor across a virtual ZIP operation, or retry its errors.
        ZipEntry entry = zip.getEntry(path);
        if (entry == null) {
            synchronized (this) {
                if (generation == observedGeneration && archive.get() == zip) {
                    if (!misses.containsKey(path)) {
                        if (misses.size() == MAX_MISSES) {
                            var oldest = misses.keySet().iterator();
                            oldest.next();
                            oldest.remove();
                        }
                        misses.put(path, Boolean.TRUE);
                    }
                }
            }
        }
        return entry;
    }

    public synchronized void clear() {
        generation++;
        misses.clear();
        archive.clear();
    }
}
