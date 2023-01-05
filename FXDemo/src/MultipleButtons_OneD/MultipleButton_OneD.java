/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultipleButtons_OneD;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class MultipleButton_OneD extends Application {

    Button[] butts1;
    Button[] butts2;
    Button btnRestart;
    Label lblResult, lblScore, lblSide;
    OneTwoThreeFour app;
    boolean left = false, right = true;
    int num;

    public MultipleButton_OneD() {
        butts1 = new Button[4];
        butts2 = new Button[4];
        btnRestart = new Button("Restart");
        lblResult = new Label("");
        lblScore = new Label("");
        lblSide = new Label("Click Left");
        app = new OneTwoThreeFour();
    }

    @Override
    public void start(Stage primaryStage) {
        app.generate();

        for (int i = 0; i < butts1.length; i++) {
            butts1[i] = new Button();
            butts1[i].setPrefSize(50, 50);
        }

        for (int i = 0; i < butts1.length; i++) {
            butts1[i].setText(app.buttons1[i] + "");
        }

        for (int i = 0; i < butts2.length; i++) {
            butts2[i] = new Button();
            butts2[i].setPrefSize(50, 50);
        }

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.getColumnConstraints().addAll(c1, c2);

        for (int i = 0; i < butts1.length; i++) {
            pane.addRow(i + 1, butts1[i], butts2[i]);
        }

        pane.addRow(0, lblSide);
        pane.addRow(5, lblResult);
        pane.addRow(6, lblScore);
        pane.addRow(7, btnRestart);

        butts1[0].setOnAction(e -> buttsLeft(0));
        butts1[1].setOnAction(e -> buttsLeft(1));
        butts1[2].setOnAction(e -> buttsLeft(2));
        butts1[3].setOnAction(e -> buttsLeft(3));
        butts2[0].setOnAction(e -> buttsRight(0));
        butts2[1].setOnAction(e -> buttsRight(1));
        butts2[2].setOnAction(e -> buttsRight(2));
        butts2[3].setOnAction(e -> buttsRight(3));
        btnRestart.setOnAction(e -> btnRestart(primaryStage));

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void buttsLeft(int num) {
        if (left == false) {
            app.num1 = app.buttons1[num];
            left = true;

            if (app.result == false && right == true) {
                butts2[this.num].setText("");
            }
            right = false;
            this.num = num;

            lblSide.setText("Click Right");
        }
    }

    public void buttsRight(int num) {
        if (left == true && right != true) {
            app.num2 = app.buttons2[num];
            butts2[num].setText(app.num2 + "");
            app.check();

            lblResult.setText(app.result + "");
            lblScore.setText(app.score + "");

            right = true;
            left = false;
            if (app.result == true) {
                butts2[num].setDisable(true);
                butts1[this.num].setDisable(true);
                /*butts2[num].setOnAction(e -> btnNull());
                butts1[this.num].setOnAction(e -> btnNull());*/
            }
            this.num = num;

            lblSide.setText("Click Left");
        }
    }

    public void btnRestart(Stage primaryStage) {
        app = new OneTwoThreeFour();
        start(primaryStage);
        lblScore.setText(0 + "");
        lblResult.setText("");
        lblSide.setText("Click Left");

    }

    public void btnNull() {
    }

}
