package be.renaud11232.sortfx.view;

import be.renaud11232.sortfx.components.BarPlot;
import be.renaud11232.sortfx.components.DisparityDots;
import be.renaud11232.sortfx.components.Visualization;

import java.util.function.Function;

public enum VisualizationType {
    BAR_GRAPH("Bar Plot", o -> new BarPlot()),
    DISPARITY_DOTS("Disparity Dots", o -> new DisparityDots());

    private final String name;
    private final Function<Object, Visualization> getter;

    VisualizationType(String name, Function<Object, Visualization> getter) {
        this.name = name;
        this.getter = getter;
    }

    public Visualization get() {
        return getter.apply(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
