package be.renaud11232.sortfx.model;

import java.util.Arrays;

public class Array<T> {

    private final Object[] data;

    public Array(int size) {
        data = new Object[size];
    }

    public int length() {
        return data.length;
    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        return (T) data[i];
    }

    @SuppressWarnings("unchecked")
    public T set(int i, T value) {
        return (T)(data[i] = value);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
