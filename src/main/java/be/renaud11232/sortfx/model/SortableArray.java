package be.renaud11232.sortfx.model;

import java.util.Random;

public class SortableArray<T extends Comparable<T>> extends Array<T> {

    public SortableArray(int size) {
        super(size);
    }

    public void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    public boolean isSorted() {
        for(int i = 1; i < length(); i++) {
            if(get(i - 1).compareTo(get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public void shuffle() {
        Random random = new Random();
        for(int i = length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(i, j);
        }
    }

}
