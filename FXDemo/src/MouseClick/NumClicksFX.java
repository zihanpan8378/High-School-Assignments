/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MouseClick;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class NumClicksFX extends Application {
    
    Button btnC;
    NumClicks nc;
    Label lblClick;
    Slider slider;
    
    public NumClicksFX() {
        btnC = new Button("Click me!");
        nc = new NumClicks();
        lblClick = new Label();
        slider = new Slider(0, 10, 0);
    }
    
    @Override
    public void start(Stage primaryStage) {
        btnC.setOnAction(e -> btnCountClick());
        
        ColumnConstraints c1 = new ColumnConstraints(300);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        
        grid.getColumnConstraints().addAll(c1);
        
        grid.addRow(0, btnC);
        grid.addRow(1, lblClick);
        grid.addRow(2, slider);
        
        Scene scene = new Scene(grid, 300, 250);
        
        primaryStage.setTitle("Click Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void btnCountClick() {
        nc.countClick();
        lblClick.setText(nc.toString());
    }
    
}
