/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

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
public class TicTacToeFX extends Application {

    Button[][] table;
    Button restart;
    Label result;
    TicTacToe app;
    int count;

    public TicTacToeFX() {
        table = new Button[3][3];
        restart = new Button("again");
        result = new Label("");
        app = new TicTacToe();

    }

    @Override
    public void start(Stage primaryStage) {
        for (int a = 0; a < table.length; a++) {
            for (int b = 0; b < table.length; b++) {
                table[a][b] = new Button();
                table[a][b].setPrefSize(50, 50);
            }
        }

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        for (int i = 0; i < table.length; i++) {
            pane.addRow(i + 1, table[i][0], table[i][1], table[i][2]);
        }
        pane.addRow(4, result);
        pane.addRow(5, restart);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                final int x = i, z = j;
                table[i][j].setOnAction(e -> btnClick(x, z));
            }
        }
        restart.setOnAction(e -> btnRestart());

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnClick(int a, int b) {
        count++;
        //if (app.table[a][b].equals(null)) {
        app.playerAction(a, b);
        table[a][b].setText(app.symbol);
        table[a][b].setOnAction(e -> btnNull());
        //table[a][b].setDisable(true);
        app.check();
        if (app.result == true) {
            result.setText(app.symbol + " Wins");
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    table[i][j].setOnAction(e -> btnNull());
                }
            }
        }
        if (count == 9 && app.result == false) {
            System.out.println("Draw");
            result.setText("Draw");
        }
        if (app.symbol.equals("X")) {
            app.symbol = "O";
        } else {
            app.symbol = "X";
        }
    }

    public void btnNull() {

    }

    public void btnRestart() {
        result.setText("");
        app = new TicTacToe();
        for (int a = 0; a < table.length; a++) {
            for (int b = 0; b < table.length; b++) {
                table[a][b].setText("");
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                final int x = i, z = j;
                table[i][j].setOnAction(e -> btnClick(x, z));
            }
        }
    }

}
