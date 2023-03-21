package com.shandrikov.dataStructures;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimeOutMap <K, V> extends ConcurrentHashMap<K, V> {
    private Map<K, LocalDateTime> mapTimestamps = new HashMap<>();

    public Map<K, LocalDateTime> getMapTimestamps() {
        return mapTimestamps;
    }

    @Override
    public V put(K key, V value) {
        if (checkIfNotExpired(key)) {
            super.put(key, value);
            mapTimestamps.put(key, LocalDateTime.now());
        }
        return value;
    }

    private boolean checkIfNotExpired(K key) {
        LocalDateTime t = mapTimestamps.get(key);
        if (t == null) return true;
        return t.isBefore(LocalDateTime.now());
    }
}
