/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToggleGroup;

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
public class ToggleGroupFX extends Application {

    Button btnTotal;
    ToggleGroup tg;
    Label lblT, lblP, lblN, lblD, lblQ;
    TextField tP, tN, tD, tQ;

    public ToggleGroupFX() {
        tg = new ToggleGroup();

        btnTotal = new Button("Total");

        lblT = new Label("0.0");
        lblP = new Label("Penny");
        lblN = new Label("Nickel");
        lblD = new Label("Dime");
        lblQ = new Label("Quarter");

        tP = new TextField();
        tN = new TextField();
        tD = new TextField();
        tQ = new TextField();

    }

    @Override
    public void start(Stage primaryStage) {
        btnTotal.setOnAction(e -> btnShowTotal());
        
        GridPane grid = new GridPane();
        
        /*ColumnConstraints c1 = new ColumnConstraints(100);
        ColumnConstraints c2 = new ColumnConstraints(100);
        grid.getColumnConstraints().addAll(c1, c2);*/
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        

        grid.addRow(0, lblP, tP);
        grid.addRow(1, lblN, tN);
        grid.addRow(2, lblD, tD);
        grid.addRow(3, lblQ, tQ);
        grid.addRow(4, btnTotal, lblT);

        Scene scene = new Scene(grid, 300, 300);

        primaryStage.setTitle("Money Counter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnShowTotal() {
        tg.setPenny(Integer.parseInt(tP.getText()));
        tg.setNickel(Integer.parseInt(tN.getText()));
        tg.setDime(Integer.parseInt(tD.getText()));
        tg.setQuarter(Integer.parseInt(tQ.getText()));
        System.out.println(tg.toString());
        lblT.setText(tg.toString());
    }

}
