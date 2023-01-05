/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.lang.Object;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import static javafx.scene.transform.Transform.rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class ThreeDimensionalTicTacToe extends Application {

    Group boxGroup, sphGroup;
    HBox hBox;
    TextField tX, tY, tZ;
    Scene scene;
    Slider slider;
    boolean XC, XnC, YC, YnC;
    Camera camera;
    AnchorPane an;
    Label location, target;
    
    Material mat = new PhongMaterial();
    final PhongMaterial redMaterial = new PhongMaterial();
    Box[][][] boxs = new Box[3][3][3];
    Sphere[][][] sph = new Sphere[3][3][3];

    public ThreeDimensionalTicTacToe() {
        boxGroup = new Group();sphGroup = new Group();
        setBoxGroup();
        
        an = new AnchorPane();
        hBox = new HBox(30);
        slider = new Slider(0, 360, 0);
        tX = new TextField("x: ");
        tY = new TextField("y: ");
        tZ = new TextField("z: ");
        location = new Label("location: ");
        target = new Label("target: ");
        hBox.getChildren().addAll(sphGroup, location, target/*, tX, tY, tZ, slider*/);
        tX.getTransforms().add(new Translate(105, 0, 0));
        tY.getTransforms().add(new Translate(-93, 50, 0));
        tZ.getTransforms().add(new Translate(-290, 100, 0));
        slider.getTransforms().add(new Translate(-500, 150, 0));
        slider.setPrefWidth(300);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(60);
        
        
        redMaterial.setDiffuseColor(Color.DARKRED);
        

        camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Translate(0, 0, 500));

    }

    public final void setBoxGroup() {

        PhongMaterial pm = new PhongMaterial();
        pm.setDiffuseColor(Color.BISQUE);
        pm.setSpecularColor(Color.BISQUE);
        pm.setSpecularPower(100);
        String HERO_IMAGE_LOC
                = "";
//        pm.setBumpMap(new Image(HERO_IMAGE_LOC));

        for (int i = 0; i < boxs.length; i++) {
            for (int j = 0; j < boxs.length; j++) {
                for (int k = 0; k < boxs.length; k++) {
                    boxs[i][j][k] = new Box(100, 100, 100);
                    boxs[i][j][k].setMaterial(pm);
                    boxs[i][j][k].setDrawMode(DrawMode.FILL);
                    boxs[i][j][k].setMaterial(redMaterial);
                    
                    boxGroup.getChildren().add(boxs[i][j][k]);
                    
                    
                    
                    sph[i][j][k] = new Sphere(50);
                    sph[i][j][k].setMaterial(pm);
                    sph[i][j][k].setDrawMode(DrawMode.FILL);
                    sph[i][j][k].setMaterial(redMaterial);
                    sphGroup.getChildren().add(sph[i][j][k]);
                }
            }
        }
        int a = 100;
        boxs[0][0][0].getTransforms().add(new Translate(-a, a, a));
        boxs[0][0][1].getTransforms().add(new Translate(0, a, a));
        boxs[0][0][2].getTransforms().add(new Translate(a, a, a));
        boxs[0][1][0].getTransforms().add(new Translate(-a, a, 0));
        boxs[0][1][1].getTransforms().add(new Translate(0, a, 0));
        boxs[0][1][2].getTransforms().add(new Translate(a, a, 0));
        boxs[0][2][0].getTransforms().add(new Translate(-a, a, -a));
        boxs[0][2][1].getTransforms().add(new Translate(0, a, -a));
        boxs[0][2][2].getTransforms().add(new Translate(a, a, -a));

        boxs[1][0][0].getTransforms().add(new Translate(-a, 0, a));
        boxs[1][0][1].getTransforms().add(new Translate(0, 0, a));
        boxs[1][0][2].getTransforms().add(new Translate(a, 0, a));
        boxs[1][1][0].getTransforms().add(new Translate(-a, 0, 0));
        boxs[1][1][1].getTransforms().add(new Translate(0, 0, 0));
        boxs[1][1][2].getTransforms().add(new Translate(a, 0, 0));
        boxs[1][2][0].getTransforms().add(new Translate(-a, 0, -a));
        boxs[1][2][1].getTransforms().add(new Translate(0, 0, -a));
        boxs[1][2][2].getTransforms().add(new Translate(a, 0, -a));

        boxs[2][0][0].getTransforms().add(new Translate(-a, -a, a));
        boxs[2][0][1].getTransforms().add(new Translate(0, -a, a));
        boxs[2][0][2].getTransforms().add(new Translate(a, -a, a));
        boxs[2][1][0].getTransforms().add(new Translate(-a, -a, 0));
        boxs[2][1][1].getTransforms().add(new Translate(0, -a, 0));
        boxs[2][1][2].getTransforms().add(new Translate(a, -a, 0));
        boxs[2][2][0].getTransforms().add(new Translate(-a, -a, -a));
        boxs[2][2][1].getTransforms().add(new Translate(0, -a, -a));
        boxs[2][2][2].getTransforms().add(new Translate(a, -a, -a));

        boxs[2][2][2].setMaterial(new PhongMaterial(Color.BLUE));
        
        
        boxs[0][0][0].getTransforms().add(new Translate(-a, a, a));
        boxs[0][0][1].getTransforms().add(new Translate(0, a, a));
        boxs[0][0][2].getTransforms().add(new Translate(a, a, a));
        boxs[0][1][0].getTransforms().add(new Translate(-a, a, 0));
        boxs[0][1][1].getTransforms().add(new Translate(0, a, 0));
        boxs[0][1][2].getTransforms().add(new Translate(a, a, 0));
        boxs[0][2][0].getTransforms().add(new Translate(-a, a, -a));
        boxs[0][2][1].getTransforms().add(new Translate(0, a, -a));
        boxs[0][2][2].getTransforms().add(new Translate(a, a, -a));

        boxs[1][0][0].getTransforms().add(new Translate(-a, 0, a));
        boxs[1][0][1].getTransforms().add(new Translate(0, 0, a));
        boxs[1][0][2].getTransforms().add(new Translate(a, 0, a));
        boxs[1][1][0].getTransforms().add(new Translate(-a, 0, 0));
        boxs[1][1][1].getTransforms().add(new Translate(0, 0, 0));
        boxs[1][1][2].getTransforms().add(new Translate(a, 0, 0));
        boxs[1][2][0].getTransforms().add(new Translate(-a, 0, -a));
        boxs[1][2][1].getTransforms().add(new Translate(0, 0, -a));
        boxs[1][2][2].getTransforms().add(new Translate(a, 0, -a));

        boxs[2][0][0].getTransforms().add(new Translate(-a, -a, a));
        boxs[2][0][1].getTransforms().add(new Translate(0, -a, a));
        boxs[2][0][2].getTransforms().add(new Translate(a, -a, a));
        boxs[2][1][0].getTransforms().add(new Translate(-a, -a, 0));
        boxs[2][1][1].getTransforms().add(new Translate(0, -a, 0));
        boxs[2][1][2].getTransforms().add(new Translate(a, -a, 0));
        boxs[2][2][0].getTransforms().add(new Translate(-a, -a, -a));
        boxs[2][2][1].getTransforms().add(new Translate(0, -a, -a));
        boxs[2][2][2].getTransforms().add(new Translate(a, -a, -a));

        boxs[2][2][2].setMaterial(new PhongMaterial(Color.BLUE));
        
        
        
        
        sph[0][0][0].getTransforms().add(new Translate(-a, a, a));
        sph[0][0][1].getTransforms().add(new Translate(0, a, a));
        sph[0][0][2].getTransforms().add(new Translate(a, a, a));
        sph[0][1][0].getTransforms().add(new Translate(-a, a, 0));
        sph[0][1][1].getTransforms().add(new Translate(0, a, 0));
        sph[0][1][2].getTransforms().add(new Translate(a, a, 0));
        sph[0][2][0].getTransforms().add(new Translate(-a, a, -a));
        sph[0][2][1].getTransforms().add(new Translate(0, a, -a));
        sph[0][2][2].getTransforms().add(new Translate(a, a, -a));

        sph[1][0][0].getTransforms().add(new Translate(-a, 0, a));
        sph[1][0][1].getTransforms().add(new Translate(0, 0, a));
        sph[1][0][2].getTransforms().add(new Translate(a, 0, a));
        sph[1][1][0].getTransforms().add(new Translate(-a, 0, 0));
        sph[1][1][1].getTransforms().add(new Translate(0, 0, 0));
        sph[1][1][2].getTransforms().add(new Translate(a, 0, 0));
        sph[1][2][0].getTransforms().add(new Translate(-a, 0, -a));
        sph[1][2][1].getTransforms().add(new Translate(0, 0, -a));
        sph[1][2][2].getTransforms().add(new Translate(a, 0, -a));

        sph[2][0][0].getTransforms().add(new Translate(-a, -a, a));
        sph[2][0][1].getTransforms().add(new Translate(0, -a, a));
        sph[2][0][2].getTransforms().add(new Translate(a, -a, a));
        sph[2][1][0].getTransforms().add(new Translate(-a, -a, 0));
        sph[2][1][1].getTransforms().add(new Translate(0, -a, 0));
        sph[2][1][2].getTransforms().add(new Translate(a, -a, 0));
        sph[2][2][0].getTransforms().add(new Translate(-a, -a, -a));
        sph[2][2][1].getTransforms().add(new Translate(0, -a, -a));
        sph[2][2][2].getTransforms().add(new Translate(a, -a, -a));

        sph[2][2][2].setMaterial(new PhongMaterial(Color.BLUE));
        
    }

    public String findIndex(Box box) {
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < boxs.length; j++) {
                for (int k = 0; k < boxs.length; k++) {
                    if (boxs[i][j][k] == box) {
                        return i+""+j+k;
                    }

                }

            }

        }
        return "";
    }

    public void rotateBox(double x, double y) {
        sphGroup.getTransforms().addAll(
                new Rotate(x, Rotate.X_AXIS),
                new Rotate(y, Rotate.Y_AXIS));
    }

    public void setOnMouse() {
        double x;
        double y;
        boxGroup.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                tX.setText("x: " + (int) event.getX());
                tY.setText("y: " + (int) event.getY());
                tZ.setText("z: " + (int) event.getZ());
                location.setText("location: " + findIndex((Box) event.getTarget()));
                target.setText("target: " + event.getTarget());
                
                if(event.getClickCount() == 2 ) {
                    
                }

                System.out.println(event.getEventType());
                System.out.println(event.getButton());
                System.out.println(event.isAltDown());
                System.out.println(event.getClickCount());
                System.out.println(event.isStillSincePress());
                System.out.println("");

            }

        });

    }

    public void setKeyboardAction() {

    }

    @Override
    public void start(Stage primaryStage) {

        setOnMouse();

        PointLight light1 = new PointLight(Color.WHITE);
        light1.setTranslateX(100);
        light1.setTranslateY(100);
        light1.setTranslateZ(100);
        light1.getTransforms().add(new Translate(2000, 2000, 2000));
        
        PointLight light2 = new PointLight(Color.RED);
        light2.setTranslateX(-100);
        light2.setTranslateY(-100);
        light2.setTranslateZ(-100);
        light2.getTransforms().add(new Translate(-2000, -2000, -2000));

        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        an.getChildren().addAll(hBox, light1, light2);

        scene = new Scene(an);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        XC = true;
                        System.out.println("up");
                        break;
                    case DOWN:
                        XnC = true;
                        System.out.println("down");
                        break;
                    case LEFT:
                        YC = true;
                        break;
                    case RIGHT:
                        YnC = true;
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        XC = false;
                        break;
                    case DOWN:
                        XnC = false;
                        break;
                    case LEFT:
                        YC = false;
                        break;
                    case RIGHT:
                        YnC = false;
                        break;
                }
            }
        });

        primaryStage.setTitle("ThreeDimensionalTicTacToe");
        primaryStage.setScene(scene);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double x = 0, y = 0;
                if (XC) {
                    x = 1;
                    y = 0;
                }
                if (XnC) {
                    x = -1;
                    y = 0;
                }
                if (YC) {
                    x = 0;
                    y = 1;
                }
                if (YnC) {
                    x = 0;
                    y = -1;
                }

                rotateBox(y, x);
            }
        };
        timer.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
