package by.fstk1337.datatype;

import java.util.Arrays;

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(hashTable);
    }
}
