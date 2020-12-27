package be.renaud11232.sortfx.controller;

import be.renaud11232.sortfx.components.Visualization;
import be.renaud11232.sortfx.model.ObservableArray;
import be.renaud11232.sortfx.view.VisualizationType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Visualization visualization;
    private ObservableArray model;

    @FXML
    private ToggleGroup nav;

    @FXML
    private ComboBox<VisualizationType> graphType;

    @FXML
    private BorderPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nav.selectedToggleProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null) {
                oldValue.setSelected(true);
            }
        }));
        graphType.getItems().addAll(VisualizationType.values());
        graphType.setValue(VisualizationType.BAR_GRAPH);
        visualization = graphType.getValue().get();
        content.setCenter(graphType.getValue().get());
        setVisualization();
    }

    private void setVisualization() {
        visualization.destroy();
        visualization = graphType.getValue().get();
        visualization.setModel(model);
        content.setCenter(visualization);
    }

    @FXML
    public void onGraphTypeSelected() {
        setVisualization();
    }
}
