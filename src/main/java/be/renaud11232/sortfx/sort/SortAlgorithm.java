package be.renaud11232.sortfx.sort;

import be.renaud11232.sortfx.model.SortableArray;

public enum SortAlgorithm implements Sort {
    BUBBLE(new BubbleSort()),
    SELECTION(new SelectionSort());

    private final Sort sort;

    SortAlgorithm(Sort sort) {
        this.sort = sort;
    }

    @Override
    public void sort(SortableArray array) {
        sort.sort(array);
    }

    @Override
    public String getName() {
        return sort.getName();
    }


}
