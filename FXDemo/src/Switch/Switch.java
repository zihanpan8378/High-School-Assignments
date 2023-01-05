/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Switch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class Switch extends Application {

    Button btnClick, btnSwitch, btnAdd, btnSubtract;
    Label lblTime, lblNum;
    Scene scene1, scene2;
    int click, num;
    Stage stage;
    GridPane pane1, pane2;

    public Switch() {
        btnClick = new Button("Click");
        btnSwitch = new Button("Switch");
        btnAdd = new Button("Add");
        btnSubtract = new Button("Subtract");
        click = 0;
        num = 0;
        lblTime = new Label("You clicked me " + click + "times");
        lblNum = new Label(num + "");

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        btnClick.setOnAction(e -> btnClick());
        btnSwitch.setOnAction(e -> btnSwitch());
        btnAdd.setOnAction(e -> btnAdd());
        btnSubtract.setOnAction(e -> btnSubtract());

        pane1 = new GridPane();
        pane2 = new GridPane();
        pane1.setHgap(10);
        pane1.setVgap(10);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);

        pane1.addRow(0, lblTime);
        pane1.addRow(1, btnClick);
        pane1.addRow(2, btnSwitch);
        pane2.addRow(0, lblNum, btnAdd, btnSubtract);

        scene1 = new Scene(pane1, 300, 300);
        scene2 = new Scene(pane2, 400, 100);

        primaryStage.setTitle("Switch");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnClick() {
        click++;
        lblTime.setText("You clicked me " + click + "times");
    }

    public void btnAdd() {
        num++;
        lblNum.setText(num + "");
    }

    public void btnSubtract() {
        num--;
        lblNum.setText(num + "");
    }

    public void btnSwitch() {
        if (stage.getScene() == scene1) {
            stage.setScene(scene2);
            stage.show();
            pane2.addRow(0, btnSwitch);
            
        } else {
            stage.setScene(scene1);
            stage.show();
            pane1.addRow(2, btnSwitch);
        }
    }

}
