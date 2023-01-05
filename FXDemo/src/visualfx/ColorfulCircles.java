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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class ColorfulCircles extends Application {
    
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
//        
//        //makes a group of circles consisting of 30 circles 
//        Group circles = new Group();
//        for (int i = 0; i < 30; i++) {
//            //radius of 150, fill color white with opacity of 5%
//            Circle circle = new Circle(150, Color.web("white", 0.5));
//            //creating a border around the circles
//            circle.setStrokeType(StrokeType.OUTSIDE);
//            circle.setStroke(Color.web("white", 0.16));
//            circle.setStrokeWidth(4);
//            //adds the circle to the group
//            circles.getChildren().add(circle);
//        }
//        //adds the circles group to the root node
//        root.getChildren().add(circles);
//        

        
        
        primaryStage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
