package org.example;

public class List<T> {

    T[] data;
    int capacity;
    double loadFactor;
    int size;
    public List(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public List() {
        this(16, 0.75);
    }

    public void add(T object) {
        data[size] = object;
        size++;
        if ((double) size / capacity > loadFactor) {
            resize();
        }
    }

    public boolean contains(T object) {
        for (T elem : data) {
            if (elem == object) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T object) {
        boolean result = false;
        T[] newData = (T[]) new Object[size - 1];
        int i = 0;
        int j = 0;
        while (i < size) {
            if (data[i].equals(object) & !result) {
                result = true;
                i++;
            }
            newData[j] = data[i];
            i++;
            j++;
        }
        data = newData;
        size--;
        return result;
    }

    public T getValue(int index) {
        return data[index];
    }

    public Integer getIndex(T object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return null;
    }

    public void resize() {
        T[] newData = (T[]) new Object[capacity + 16];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        capacity += 16;
    }

    public int getSize() {
        return size;
    }

    public T[] getData() {
        return data;
    }
}
