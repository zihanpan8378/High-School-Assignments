/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOf21;

import ToggleGroup.ToggleGroup;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class GameOf21FX extends Application {

    Button btnYes, btnNo, btnStart;
    GameOf21 game;
    Label lblPC, lblP3C, lblCC, lblCTotal, lblPTotal,
            lblP1, lblP2, lblC1, lblC2, lblResult;
    boolean click, start;

    public GameOf21FX() {
        game = new GameOf21();

        btnYes = new Button("Yes");
        btnNo = new Button("No");
        btnStart = new Button("Start");

        lblPC = new Label("Player cards");
        lblP3C = new Label("Player's third card");
        lblCC = new Label("Computer's card");
        lblCTotal = new Label("");
        lblPTotal = new Label("");
        lblP1 = new Label("");
        lblP2 = new Label("");
        lblC1 = new Label("");
        lblC2 = new Label("");
        lblResult = new Label("");
    }

    @Override
    public void start(Stage primaryStage) {
        btnYes.setOnAction(e -> btnYes());
        btnNo.setOnAction(e -> btnNo());
        btnStart.setOnAction(e -> btnStart());

        GridPane grid = new GridPane();

        /*ColumnConstraints c1 = new ColumnConstraints(100);
        ColumnConstraints c2 = new ColumnConstraints(100);
        grid.getColumnConstraints().addAll(c1, c2);*/
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.addRow(0, lblPC, lblP1, lblP2, lblPTotal);
        grid.addRow(1, lblP3C, btnNo, btnYes);
        grid.addRow(2, lblCC, lblC1, lblC2, lblCTotal);
        grid.addRow(3, lblResult);
        grid.addRow(4, btnStart);

        Scene scene = new Scene(grid, 500, 500);

        primaryStage.setTitle("Basic BackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnStart() {
        if (start == true) {
            game = new GameOf21();
            lblCTotal.setText("");
            lblPTotal.setText("");
            lblP1.setText("");
            lblP2.setText("");
            lblC1.setText("");
            lblC2.setText("");
            lblResult.setText("");
            btnYes.setText("Yes");
            click = false;
            start = false;
            btnStart.setText("Start");
        }
        else {
        game.generat();
        lblC1.setText("" + game.c[0]);
        lblC2.setText("" + game.c[1]);
        lblP1.setText("" + game.c[2]);
        lblP2.setText("" + game.c[3]);
        start = true;
        btnStart.setText("Reset");}
    }

    public void btnYes() {
        if (click == true || lblC1.getText().equals("")) {

        } else {
            game.thirdCard(true);
            btnYes.setText("" + game.c[4]);
            lblResult.setText(game.result());
            lblPTotal.setText("" + game.tp);
            lblCTotal.setText("" + game.tc);
            click = true;
        }
    }

    public void btnNo() {
        if (click == true || lblC1.getText().equals("")) {

        } else {
            game.thirdCard(false);
            lblResult.setText(game.result());
            lblPTotal.setText("" + game.tp);
            lblCTotal.setText("" + game.tc);
            click = true;
        }
    }

}
