/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class 转 extends Application {

    Box box = new Box(200, 200, 200);
    Slider sliderX = new Slider(0, 360, 0);
    Slider sliderY = new Slider(0, 360, 0);
    PerspectiveCamera camera = new PerspectiveCamera(true);
    Scene scene;
    HBox hBox = new HBox(20);

    public 转() {
        
    }
    
    public void RotateBox(int x, int y, int z) {
        box.getTransforms().addAll(
                new Rotate(x, Rotate.Y_AXIS),
                new Rotate(y, Rotate.X_AXIS),
                new Rotate(z, Rotate.Z_AXIS));
    }

    @Override
    public void start(Stage primaryStage) {
        //sliderX.getTransforms().add(new Translate(0, 300, 0));
        //sliderY.getTransforms().add(new Translate(0, 400, 0));
        box.rotateProperty().bind(sliderX.valueProperty());
        box.rotateProperty().bind(sliderY.valueProperty());
        box.setMaterial(new PhongMaterial(Color.RED));
        box.getTransforms().addAll(
                new Rotate(20, Rotate.Y_AXIS),
                new Rotate(20, Rotate.X_AXIS),
                new Rotate(20, Rotate.Z_AXIS));
        hBox.getChildren().addAll(sliderX, sliderY, box);
                
        box.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                System.out.println("x: " + event.getX());
                System.out.println("y: " + event.getY());
                System.out.println("z: " + event.getZ());
            }
        });
        
        AnchorPane an = new AnchorPane();
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        an.getChildren().add(hBox);
        //camera.getTransforms().add(new Translate(0, 0, -70));
        scene = new Scene(an);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1300);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
