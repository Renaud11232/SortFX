package be.renaud11232.sortfx.model;

import java.util.LinkedList;
import java.util.List;

public class ObservableArray {

    private List<ArrayObserver> observers;

    public ObservableArray() {
        observers = new LinkedList<>();
    }

    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ArrayObserver observer) {
        observers.remove(observer);
    }

}
