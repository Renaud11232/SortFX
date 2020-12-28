package be.renaud11232.sortfx.controller;

import be.renaud11232.sortfx.components.Visualization;
import be.renaud11232.sortfx.sort.SortAlgorithm;
import be.renaud11232.sortfx.view.DisplayableArray;
import be.renaud11232.sortfx.sort.Sort;
import be.renaud11232.sortfx.view.VisualizationType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Visualization visualization;
    private DisplayableArray array;

    @FXML
    private ComboBox<VisualizationType> graphType;

    @FXML
    private BorderPane content;

    @FXML
    private VBox nav;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initNavButtons();
        graphType.getItems().addAll(VisualizationType.values());
        graphType.setValue(VisualizationType.BAR_GRAPH);
        showVisualization();
        createArray();
    }

    private void initNavButtons() {
        ToggleGroup navGroup = new ToggleGroup();
        navGroup.selectedToggleProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null) {
                oldValue.setSelected(true);
            } else {

            }
        }));
        boolean first = true;
        for(Sort sort : SortAlgorithm.values()) {
            ToggleButton toggleButton = new ToggleButton(sort.getName());
            toggleButton.setAlignment(Pos.CENTER_LEFT);
            toggleButton.setMaxHeight(48.0);
            toggleButton.setMaxWidth(Double.MAX_VALUE);
            toggleButton.setMinHeight(48.0);
            toggleButton.setPrefHeight(48.0);
            toggleButton.setToggleGroup(navGroup);
            toggleButton.setUserData(sort);
            if(first) {
                first = false;
                toggleButton.setSelected(true);
            }
            nav.getChildren().add(toggleButton);
        }
    }

    private void showVisualization() {
        if(visualization != null) {
            visualization.destroy();
        }
        visualization = graphType.getValue().get();
        visualization.setModel(array);
        content.setCenter(visualization);
    }

    private void createArray() {
        array = new DisplayableArray(1000);
        for(int i = 0; i < array.length(); i++) {
            array.set(i, i);
        }
        visualization.setModel(array);
    }

    @FXML
    public void onGraphTypeSelected() {
        showVisualization();
    }
}
