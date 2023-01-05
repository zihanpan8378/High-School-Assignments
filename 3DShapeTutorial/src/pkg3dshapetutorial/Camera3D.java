/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dshapetutorial;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
 
/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Camera3D extends Application {
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Sphere sphere = new Sphere(50);
 
        Group group = new Group();
        group.getChildren().add(sphere);
 
        //Create new Camera
        Camera camera = new PerspectiveCamera(true);
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        //Attach to scene
        scene.setCamera(camera);
 
        //Move back a little to get a good view of the sphere
        camera.translateZProperty().set(-500);
 
        //Set the clipping planes
        camera.setNearClip(1);
        camera.setFarClip(1000);
 
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    camera.translateZProperty().set(camera.getTranslateZ() + 100);
                    break;
                case S:
                    camera.translateZProperty().set(camera.getTranslateZ() - 100);
                    break;
            }
        });
 
        primaryStage.setTitle("Genuine Coder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
 