package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Object[] key = new Object[MAX_STORAGE_SIZE];
    private Object[] value = new Object[MAX_STORAGE_SIZE];
    private int storageSize;

    @Override
    public void put(K key, V value) {
        int findIndex = findIndex(key);
        this.value[findIndex] = value;
        this.key[findIndex] = key;
        if (findIndex == storageSize) {
            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        return (V) value[findIndex(key)];
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int findIndex(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (this.key[i] == key || key != null && key.equals(this.key[i])) {
                return i;
            }
        }
        return size();
    }
}
