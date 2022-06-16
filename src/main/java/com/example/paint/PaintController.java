package com.example.paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class PaintController implements Initializable {
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Canvas canvas;
    GraphicsContext brushTool;

    boolean toolSelected = false;
    boolean clearSelected = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        brushTool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = 10;
            double x = e.getX() - 5;
            double y = e.getY() - 5;
            if (clearSelected) {
                brushTool.setFill(Color.WHITE);
                brushTool.fillRoundRect(x, y, size, size, size, size);
            }
            if (toolSelected) {
                brushTool.setFill(colorPicker.getValue());
                brushTool.fillRoundRect(x, y, size, size, size, size);
            }
        });
    }

    @FXML
    public void clickInDraw(ActionEvent e) {
        toolSelected = !toolSelected;
        clearSelected = false;
    }

    @FXML
    public void clickInClear(ActionEvent e) {
        clearSelected = !clearSelected;
        toolSelected = false;
    }
}
