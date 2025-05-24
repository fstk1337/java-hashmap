package by.fstk1337.datatype;

import java.util.Objects;

public class Entry<K, V> {
    private final K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
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
    public String toString() {
        return (this.key + ": " + this.value);
    }
}
