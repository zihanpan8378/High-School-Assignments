/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizApp;

import GameOf21.GameOf21;
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
public class QuizAppFX extends Application {

    Button btnA, btnB, btnC, btnNext;
    QuizApp app;
    Label lblQuestionNum, lblQuestion, lblO1, lblO2, lblO3, lblResult, lblScore;
    boolean click;

    public QuizAppFX() {
        btnA = new Button("A");
        btnB = new Button("B");
        btnC = new Button("C");
        btnNext = new Button("Next Question");

        app = new QuizApp();

        lblQuestionNum = new Label("Question #" + (app.i + 1));
        lblQuestion = new Label(app.q[app.i].question);
        lblO1 = new Label(app.q[app.i].options[0]);
        lblO2 = new Label(app.q[app.i].options[1]);
        lblO3 = new Label(app.q[app.i].options[2]);
        lblResult = new Label("");
        lblScore = new Label(app.score + " out of 3");
    }

    @Override
    public void start(Stage primaryStage) {
        btnA.setOnAction(e -> btnA());
        btnB.setOnAction(e -> btnB());
        btnC.setOnAction(e -> btnC());
        btnNext.setOnAction(e -> btnNext());

        GridPane grid = new GridPane();

        ColumnConstraints c1 = new ColumnConstraints(100);
        ColumnConstraints c2 = new ColumnConstraints(100);
        grid.getColumnConstraints().addAll(c1, c2);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.addRow(0, lblQuestionNum);
        grid.addRow(1, lblQuestion);
        grid.addRow(2, btnA, lblO1);
        grid.addRow(3, btnB, lblO2);
        grid.addRow(4, btnC, lblO3);
        grid.addRow(5, lblResult, lblScore);
        grid.addRow(6, btnNext);

        Scene scene = new Scene(grid, 500, 500);

        primaryStage.setTitle("Quiz App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnA() {
        if (click == true) {

        } else {
            lblResult.setText(app.result("A"));
            lblScore.setText(app.score + "out of 3");
            click = true;
        }
    }

    public void btnB() {
        if (click == true) {

        } else {
            lblResult.setText(app.result("B"));
            lblScore.setText(app.score + "out of 3");
            click = true;

        }
    }

    public void btnC() {
        if (click == true) {

        } else {
            lblResult.setText(app.result("C"));
            lblScore.setText(app.score + "out of 3");
            click = true;

        }
    }

    public void btnNext() {
        if (app.i < app.q.length - 1) {
            app.i++;
            lblQuestionNum.setText("Question #" + (app.i + 1));
            lblQuestion.setText(app.q[app.i].question);
            lblO1.setText(app.q[app.i].options[0]);
            lblO2.setText(app.q[app.i].options[1]);
            lblO3.setText(app.q[app.i].options[2]);
            lblResult.setText("");
            click = false;
            if (app.i == app.q.length - 1) {
                btnNext.setText("Resrart");
            }
        } else {
            app = new QuizApp();
            lblQuestionNum.setText("Question #" + (app.i + 1));
            lblQuestion.setText(app.q[app.i].question);
            lblO1.setText(app.q[app.i].options[0]);
            lblO2.setText(app.q[app.i].options[1]);
            lblO3.setText(app.q[app.i].options[2]);
            lblResult.setText("");
            lblScore.setText(app.score + "out of 3");
            click = false;

        }

    }

}
