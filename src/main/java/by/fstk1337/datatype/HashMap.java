package by.fstk1337.datatype;

import java.util.Arrays;
import java.util.Objects;

public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private final Entry<K, V>[] hashTable;
    private final int capacity;
    private int size;

    public HashMap() {
        capacity = DEFAULT_CAPACITY;
        hashTable = new Entry[DEFAULT_CAPACITY];
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        hashTable = new Entry[capacity];
    }

    private static int index(Object key, int capacity) {
        int hash = key.hashCode();
        return hash & (capacity - 1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        int index = index(key, capacity);
        Entry<K, V> entry = hashTable[index];
        if (Objects.isNull(entry)) {
            hashTable[index] = new Entry<>(index, key, value, null);
            size += 1;
            return null;
        } else {
            while (entry.hasNext()) {
                if (entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    entry.setValue(value);
                    size +=1;
                    return oldValue;
                }
                entry = entry.getNext();
            }
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                size += 1;
                return oldValue;
            }
            entry.setNext(new Entry<>(index, key, value, null));
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(hashTable);
    }
}
