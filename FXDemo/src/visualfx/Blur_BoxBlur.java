/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class Blur_BoxBlur extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);

        BoxBlur boxBlur = new BoxBlur();
        boxBlur.setWidth(10);
        boxBlur.setHeight(3);
        boxBlur.setIterations(3);

        Text text = new Text();
        text.setText("Blurry Text!");
        text.setFill(Color.web("0x3b596d"));
        text.setFont(Font.font(null, FontWeight.BOLD, 50));
        text.setX(10);
        text.setY(50);
        text.setEffect(boxBlur);
        
        root.getChildren().add(text);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
