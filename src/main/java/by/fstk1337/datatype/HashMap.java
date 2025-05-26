package by.fstk1337.datatype;

import java.util.*;

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

    static class Entry<K, V> {
        private final int hash;
        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean hasNext() {
            return Objects.nonNull(next);
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this)
                return true;
            if (Objects.isNull(object) || object.getClass() != this.getClass())
                return false;
            Entry<K, V> entry = (Entry<K, V>) object;
            return entry.getKey().equals(this.getKey()) && entry.getValue().equals(this.getValue());
        }

        @Override
        public int hashCode() {
            int keyHash = Objects.hashCode(key);
            int valueHash = Objects.hashCode(value);
            return keyHash ^ valueHash;
        }

        @Override
        public String toString() {
            return ("[" + this.hash + ": { " + this.key + ": " + this.value + " }, next: " + this.next + "]");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        if (Objects.isNull(key))
            return false;
        int index = index(key, capacity);
        Entry<K, V> entry = hashTable[index];
        if (Objects.isNull(entry)) {
            return false;
        }
        while (Objects.nonNull(entry)) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty() && Arrays.equals(hashTable, new Entry[capacity]))
            return false;
        for (Entry<K, V> entry: hashTable) {
            while (Objects.nonNull(entry)) {
                if (entry.getValue().equals(value))
                    return true;
                entry = entry.getNext();
            }
        }
        return false;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        if (isEmpty() && Arrays.equals(hashTable, new Entry[capacity]))
            return keySet;
        for (Entry<K, V> entry: hashTable) {
            while (Objects.nonNull(entry)) {
                keySet.add(entry.getKey());
                entry = entry.getNext();
            }
        }
        return keySet;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        if (isEmpty() && Arrays.equals(hashTable, new Entry[capacity]))
            return values;
        for (Entry<K, V> entry: hashTable) {
            while (Objects.nonNull(entry)) {
                values.add(entry.getValue());
                entry = entry.getNext();
            }
        }
        return values;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        if (isEmpty() && Arrays.equals(hashTable, new Entry[capacity]))
            return entrySet;
        for (Entry<K, V> entry: hashTable) {
            while (Objects.nonNull(entry)) {
                entrySet.add(entry);
                entry = entry.getNext();
            }
        }
        return entrySet;
    }

    public void clear() {
        if (isEmpty() && Arrays.equals(hashTable, new Entry[capacity]))
            return;
        Arrays.fill(hashTable, null);
        size = 0;
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
