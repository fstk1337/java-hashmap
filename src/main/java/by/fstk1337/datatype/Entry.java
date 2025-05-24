package by.fstk1337.datatype;

import java.util.Objects;

public class Entry<K, V> {
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
