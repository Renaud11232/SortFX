package be.renaud11232.sortfx.components;

import be.renaud11232.sortfx.model.ArrayObserver;
import be.renaud11232.sortfx.model.ObservableArray;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Visualization extends Region implements ArrayObserver {

    private ObservableArray model;

    public Visualization() {
        Rectangle test = new Rectangle();
        test.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        test.xProperty().setValue(0);
        test.yProperty().setValue(0);
        test.widthProperty().bind(widthProperty());
        test.heightProperty().bind(heightProperty());
        getChildren().add(test);
    }

    public void setModel(ObservableArray array) {
        if(model != null) {
            model.removeObserver(this);
        }
        model = array;
        if(model != null) {
            model.addObserver(this);
            draw();
        }
    }

    public void destroy() {
        setModel(null);
    }

    protected ObservableArray getModel() {
        return model;
    }

    protected abstract void draw();

}
