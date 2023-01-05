/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class DragMovement extends Application {

    Circle circle;
    double sceneX, sceneY, translateX, translateY;

    @Override
    public void start(Stage primaryStage) {
        circle = new Circle(50.0f, Color.RED);
        circle.setCursor(Cursor.CROSSHAIR);
        circle.setCenterX(150);
        circle.setCenterY(150);
        circle.setOnMousePressed(circleOnMousePressed);
        circle.setOnMouseDragged(circleOnMouseDragged);
        Group root = new Group();
        root.getChildren().add(circle);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<MouseEvent> circleOnMousePressed = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            //returns position of the event relative to the origin of the Scene
            sceneX = event.getSceneX();
            sceneY = event.getSceneY();
            translateX = ((Circle) (event.getSource())).getTranslateX();
            translateY = ((Circle) (event.getSource())).getTranslateY();
        }

    };
    
    EventHandler<MouseEvent> circleOnMouseDragged = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            double offsetX = event.getSceneX() - sceneX;
            double offsetY = event.getSceneY() - sceneY;
            double newTranslateX = translateX + offsetX;
            double newTranslateY = translateY + offsetY;
            
            ((Circle) (event.getSource())).setTranslateX(newTranslateX);
            ((Circle) (event.getSource())).setTranslateY(newTranslateY);
        }
    };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
