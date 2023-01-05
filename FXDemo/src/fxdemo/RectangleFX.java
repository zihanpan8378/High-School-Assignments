/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class RectangleFX extends Application {

    Button btnA, btnP;
    Label lLen, lWid, lPerimeter, lArea;
    TextField tLen, tWid;
    GridPane grid;
    Rectangle r;

    public RectangleFX() {
        r = new Rectangle();
        btnA = new Button("Area");
        btnP = new Button("Perimeter");
        lLen = new Label("Length");
        lWid = new Label("Width");
        tLen = new TextField();
        tWid = new TextField();
        lPerimeter = new Label("Perimeter");
        lArea = new Label("Area");

    }

    @Override
    public void start(Stage primaryStage) {
        btnA.setOnAction(e -> btnArea());
        btnP.setOnAction(e -> btnPerimeter());

        ColumnConstraints c1 = new ColumnConstraints(100);
        ColumnConstraints c2 = new ColumnConstraints(10);

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.getColumnConstraints().addAll(c1, c2);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.addRow(0, lLen, tLen);
        grid.addRow(1, lWid, tWid);
        grid.addRow(2, btnA, btnP);
        grid.addRow(3, lArea);
        grid.addRow(4, lPerimeter);
        
        
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setTitle("Area, Perimeter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void btnArea() {
        r.setLength(Integer.parseInt((tLen.getText())));
        r.setWidth(Integer.parseInt(tWid.getText()));
        System.out.println("Area: " + r.getArea());
        lArea.setText("Area: " + r.getArea());
    }

    private void btnPerimeter() {
        r.setLength(Integer.parseInt((tLen.getText())));
        r.setWidth(Integer.parseInt(tWid.getText()));
        System.out.println("Perimeter: " + r.getPerimeter());
        lPerimeter.setText("Perimeter: " + r.getPerimeter());
    }

}
