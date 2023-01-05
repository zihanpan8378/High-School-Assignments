/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgressBar;

import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.Timer;

/**
 *
 * @author 44869
 */
public class ProgressBarExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    double count = 0;
    Timer timer;
    ProgressBar progressBar = new ProgressBar();
    Button button1 = new Button(), button2 = new Button();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        progressBar.setProgress(0.1);

        button1.setText("1");
        button2.setText("2");
        button1.setOnAction(e -> timerReset());
        button2.setOnAction(e -> timerReset());

        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (count < 3000) {
                    count++;
                    progressBar.setProgress(1 - count / 3000);
                    System.out.println(1 - count / 3000);
                } else if (count == 3000) {
                    timer.stop();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            button1.setText("999");
                        }
                    });
                }
            }
        });

        VBox vBox = new VBox(progressBar, button1, button2);
        Scene scene = new Scene(vBox, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void timerReset() {
        if (count == 0) {
            timer.start();
        } else if (count == 3000) {
            timer.stop();
            count = 0;
            progressBar.setProgress(1);
            timer.start();
        } else {
            timer.stop();
            count = 0;
            progressBar.setProgress(1);
        }

    }

}
