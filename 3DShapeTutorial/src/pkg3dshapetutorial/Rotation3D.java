/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dshapetutorial;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Rotation3D extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    //Tracks drag starting point for x and y
    private double anchorX, anchorY;
    //Keep track of current angle for x and y
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    //We will update these after drag. Using JavaFX property to bind with object
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    //Prepare X and Y axis rotation transformation obejcts
    private Rotate xRotate;
    private Rotate yRotate;
    //Create Material
    PhongMaterial material = new PhongMaterial();
    PhongMaterial diffuseMap = new PhongMaterial();
    

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        //Set diffuse map
        //Applying wooden texture
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("wood.jpg")));
        //Set specular map
        //material.setSpecularMap(new Image(getClass().getResourceAsStream("illuminati.jpg")));

        //Create a box
        Box box = new Box(100, 20, 50);
        //Apply material for the box
        box.setMaterial(material);
        return box;
    }

    @Override
    public void start(Stage primaryStage) {

        //Prepare transformable Group container
        SmartGroup group = new SmartGroup();
        //Add all the components
        group.getChildren().add(prepareBox());
        //Add a light (either pointLight or ambientLight
        group.getChildren().add(prepareAmbientLightSource());

        Camera camera = new PerspectiveCamera();
        //Create new scene with depth buffer enabled
        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        //Add both transformation to the container
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );

        //Move to center of the screen
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        group.translateZProperty().set(-300);

        //Add mouse control and meyboard control (two methods)
        initMouseControl(group, scene);
        initKeyboardControl(group, scene);

        primaryStage.setTitle("Genuine Coder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class SmartGroup extends Group {

        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }

    private void initKeyboardControl(SmartGroup group, Scene scene) {
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            //Process according to the key pressed.
            switch (event.getCode()) {
                case Q://Move the group farer
                    group.translateZProperty().set(group.getTranslateZ() + 100);
                    break;
                case E://Move the group closer
                    group.translateZProperty().set(group.getTranslateZ() - 100);
                    break;
                case S:
                    angleX.set(anchorAngleX - 10);
                    anchorAngleX = angleX.get();
                    break;
                case W:
                    angleX.set(anchorAngleX - (-10));
                    anchorAngleX = angleX.get();
                    break;
                case A:
                    angleY.set(anchorAngleY - 10);
                    anchorAngleY = angleY.get();
                    break;
                case D:
                    angleY.set(anchorAngleY - (-10));
                    anchorAngleY = angleY.get();
                    break;
            }
        });
    }

    private void initMouseControl(SmartGroup group, Scene scene) {

        //Bind Double property angleX/angleY with corresponding transformation. 
        //When we update angleX / angleY, the transform will also be auto updated.
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        //Listen for mouse press -- Drag start with a click
        scene.setOnMousePressed(event -> {
            //Save start points
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();

        });
        //Listen for drag
        scene.setOnMouseDragged(event -> {
            //event.getSceneY() gives current Y value. 
            //Find how much far away it is from saved anchorY point.
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY + (anchorX - event.getSceneX()));
        });
        //Listen for release -- Drag end with release
        scene.setOnMouseReleased(event -> {
            //Save current rotation angle
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        //Listen for scroll - move along z-axis
        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            //Get how much scroll was done in Y axis.
            double delta = event.getDeltaY();
            if (!((group.getTranslateZ() <= -700 && delta < 0) 
                    || (group.getTranslateZ() >= 100 && delta > 0))) {
                //Add it to the Z-axis location.
                group.translateZProperty().set(group.getTranslateZ() + delta);
            }
        });
    }

    private LightBase prepareAmbientLightSource() {
        //Create light object
        AmbientLight ambientLight = new AmbientLight();
        //Set light color
        ambientLight.setColor(Color.WHITE);
        return ambientLight;
    }

    private LightBase preparePointLightSource() {
        //Create point light
        PointLight pointLight = new PointLight();
        //Set light color
        pointLight.setColor(Color.WHITE);
        //Set location of light source
        pointLight.getTransforms().add(new Translate(0, -50, 100));
        return pointLight;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
