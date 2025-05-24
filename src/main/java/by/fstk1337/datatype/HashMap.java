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

    public V get(K key) {
        if (Objects.isNull(key))
            return null;
        int index = index(key, capacity);
        Entry<K, V> entry = hashTable[index];
        if (Objects.isNull(entry)) {
            return null;
        }
        while (Objects.nonNull(entry)) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    public V put(K key, V value) {
        if (Objects.isNull(key))
            return null;
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
                    return oldValue;
                }
                entry = entry.getNext();
            }
            entry.setNext(new Entry<>(index, key, value, null));
            size +=1;
        }
        return null;
    }

    public V remove(K key) {
        if (Objects.isNull(key))
            return null;
        int index = index(key, capacity);
        Entry<K, V> entry = hashTable[index];
        if (Objects.isNull(entry))
            return null;
        if (entry.getKey().equals(key)) {
            hashTable[index] = entry.getNext();
            entry.setNext(null);
            size -= 1;
            return entry.getValue();
        }
        while (entry.hasNext()) {
            Entry<K, V> prevEntry = entry;
            entry = entry.getNext();
            if (entry.getKey().equals(key)) {
                prevEntry.setNext(entry.getNext());
                entry.setNext(null);
                size -= 1;
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(hashTable);
    }
}
