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
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class BlendEffect extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        
        Rectangle r = new Rectangle();
        r.setX(590);
        r.setY(50);
        r.setWidth(50);
        r.setHeight(50);
        r.setFill(Color.BLUE);
 
        Circle c = new Circle();
        c.setFill(Color.RED);
        c.setCenterX(590);
        c.setCenterY(50);
        c.setRadius(25);
        c.setBlendMode(BlendMode.SRC_ATOP);
 
        Group g = new Group();
        g.setBlendMode(BlendMode.SRC_OVER);
        g.getChildren().add(r);
        g.getChildren().add(c);
        
        root.getChildren().add(g);
        
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
