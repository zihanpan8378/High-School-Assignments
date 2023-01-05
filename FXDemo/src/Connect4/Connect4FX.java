/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect4;

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
public class Connect4FX extends Application {

    Label lblResult;
    Button[][] btnTable;
    Connect4 c = new Connect4();

    public Connect4FX() {
        btnTable = new Button[6][7];
        lblResult = new Label("");
    }

    @Override
    public void start(Stage primaryStage) {
        for (int a = 0; a < btnTable.length; a++) {
            for (int b = 0; b < btnTable[0].length; b++) {
                btnTable[a][b] = new Button();
                btnTable[a][b].setPrefSize(50, 50);
            }
        }

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        for (int i = 0; i < btnTable.length; i++) {
            pane.addRow(i + 1, btnTable[i][0], btnTable[i][1], btnTable[i][2],
                    btnTable[i][3], btnTable[i][4], btnTable[i][5], btnTable[i][6]);
        }
        pane.addRow(7, lblResult);

        for (int i = 0; i < btnTable.length; i++) {
            for (int j = 0; j < btnTable[0].length; j++) {
                final int x = i, z = j;
                btnTable[i][j].setOnAction(e -> btnClick(x, z));
            }
        }

        Scene scene = new Scene(pane, 700, 700);
        primaryStage.setTitle("Connect4");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnClick(int row, int column) {
        if (c.bottom[column] >= 0) {
            if (c.player == 1) {
                btnTable[c.bottom[column]][column].setStyle("-fx-background-color: #ff9000; ");
            } else if (c.player == 2) {
                btnTable[c.bottom[column]][column].setStyle("-fx-background-color: #ff0300; ");
            }
            c.drop(column);
        }

        if (c.check() == true) {
            for (int i = 0; i < btnTable.length; i++) {
                for (int j = 0; j < btnTable[0].length; j++) {
                    final int x = i, z = j;
                    btnTable[i][j].setDisable(true);
                }
            }
            if (c.winner == 1) {
                lblResult.setText("Y wins");
            } else if (c.winner == 2) {
                lblResult.setText("R wins");
            }
        }
    }

}
