package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyMap<K, V>{
    private ArrayList<Entry<K, V>>[] array;
    private int size = 0;
    private int capacity;
    private double loadFactor;


    public MyMap() {
        this(16, 0.75);
    }

    public MyMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        array = new ArrayList[capacity];
    }

    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);

        int index = key.hashCode() % capacity;

        V returningThing = null;

        if (array[index] == null) {
            array[index] = new ArrayList<>();
            array[index].add(newEntry);
            size++;
        } else {
            if (!containsKey(key)) {
                array[index].add(newEntry);
                size++;
            } else {
                for (Entry<K, V> elem : array[index]) {
                    if (elem.getKey().equals(key)) {
                        returningThing = elem.getValue();
                        elem.setValue(value);
                        break;
                    }
                }
            }
        }
        if ((double) size / capacity > loadFactor) {
            resize();
        }
        return returningThing;
    }

    public void resize() {
        capacity *= 2;
        MyMap<K, V> newMap = new MyMap<>(capacity, loadFactor);
        for (ArrayList<Entry<K, V>> list : array) {
            if (list != null) {
                for (Entry<K, V> elem : list) {
                    newMap.put(elem.key, elem.value);
                }
            }
        }
        array = newMap.array;
    }

    public V get(@NotNull K key) {
        int index = key.hashCode() % capacity;

        if (array[index] != null) {
            for (Entry<K, V> elem : array[index]) {
                if (elem.getKey().equals(key)) {
                    return elem.getValue();
                }
            }
        }

        return null;
    }

    public boolean remove(K key) {
        int index = key.hashCode() % capacity;

        if (array[index] != null) {
            for (Entry<K, V> elem : array[index]) {
                if (elem.getKey().equals(key)) {
                    size--;
                    return array[index].remove(elem);
                }
            }
        }
        return false;
    }

    public boolean containsKey(K key) {
        int index = key.hashCode() % capacity;

        if (array[index] != null) {
            for (Entry<K, V> elem : array[index]) {
                if (elem.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (ArrayList<Entry<K, V>> list : array) {
            if (list != null) {
                for (Entry<K, V> elem : list) {
                    if (elem.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String result = "{";
        for (ArrayList<Entry<K, V>> elem : array) {
            if (elem != null) {
                for (Entry<K, V> entry : elem) {
                    result += entry + ", ";
                }
            }
        }
        result += "}";
        return result;
    }

    public int getSize() {
        return size;
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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

        public String toString() {
            return key + ": " + value;
        }
    }
}