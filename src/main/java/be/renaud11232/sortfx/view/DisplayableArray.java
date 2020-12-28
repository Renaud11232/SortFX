package be.renaud11232.sortfx.view;

import be.renaud11232.sortfx.model.ArrayObserver;
import be.renaud11232.sortfx.model.SortableArray;

import java.util.LinkedList;
import java.util.List;

public class DisplayableArray extends SortableArray<Integer> {

    private List<ArrayObserver> observers;

    public DisplayableArray(int size) {
        super(size);
        observers = new LinkedList<>();
    }

    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ArrayObserver observer) {
        observers.remove(observer);
    }

}
