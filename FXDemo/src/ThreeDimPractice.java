/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class ThreeDimPractice extends Application implements MouseMotionListener, MouseListener {

    Cylinder myCylinder;//new Cylinder(radius, height);
    Group boxGroup;
    Box[] boxs;//Box(width,height,depth);

    PhongMaterial redMaterial;
    PhongMaterial blueMaterial;
    PhongMaterial greyMaterial;

    PointLight light;
    PointLight light2;
    Slider slider;
    PerspectiveCamera camera;

    TextField tField;

    public ThreeDimPractice() {
        
        tField = new TextField(30);

        light = new PointLight(Color.WHITE);
        light.setTranslateX(50);
        light.setTranslateY(-300);
        light.setTranslateZ(-400);
        light2 = new PointLight(Color.color(0.6, 0.3, 0.4));
        light2.setTranslateX(400);
        light2.setTranslateY(0);
        light2.setTranslateZ(-400);

        slider = new Slider(0, 360, 0);
        slider.setBlockIncrement(1);
        
        //slider.setPrefSize(0.01, 0.01);
        slider.getTransforms().add(new Translate(0, 0, 50));
        //slider.setTranslateX(425);
        //slider.getTransforms().addAll(new Translate(0, -1, 0));
        //slider.setTranslateY(625);

        boxGroup = new Group();
        boxs = new Box[27];
        for (int i = 0; i < boxs.length; i++) {
            boxs[i] = new Box(2, 2, 2);
            boxs[i].setMaterial(new PhongMaterial(Color.RED));
            boxs[i].setDrawMode(DrawMode.FILL);
            boxGroup.getChildren().add(boxs[i]);
        }
        boxs[0].getTransforms().add(new Translate(-2, 2, 2));
        boxs[1].getTransforms().add(new Translate(0, 2, 2));
        boxs[2].getTransforms().add(new Translate(2, 2, 2));
        boxs[3].getTransforms().add(new Translate(-2, 2, 0));
        boxs[4].getTransforms().add(new Translate(0, 2, 0));
        boxs[5].getTransforms().add(new Translate(2, 2, 0));
        boxs[6].getTransforms().add(new Translate(-2, 2, -2));
        boxs[7].getTransforms().add(new Translate(0, 2, -2));
        boxs[8].getTransforms().add(new Translate(2, 2, -2));

        boxs[9].getTransforms().add(new Translate(-2, 0, 2));
        boxs[10].getTransforms().add(new Translate(0, 0, 2));
        boxs[11].getTransforms().add(new Translate(2, 0, 2));
        boxs[12].getTransforms().add(new Translate(-2, 0, 0));
        boxs[13].getTransforms().add(new Translate(0, 0, 0));
        boxs[14].getTransforms().add(new Translate(2, 0, 0));
        boxs[15].getTransforms().add(new Translate(-2, 0, -2));
        boxs[16].getTransforms().add(new Translate(0, 0, -2));
        boxs[17].getTransforms().add(new Translate(2, 0, -2));

        boxs[18].getTransforms().add(new Translate(-2, -2, 2));
        boxs[19].getTransforms().add(new Translate(0, -2, 2));
        boxs[20].getTransforms().add(new Translate(2, -2, 2));
        boxs[21].getTransforms().add(new Translate(-2, -2, 0));
        boxs[22].getTransforms().add(new Translate(0, -2, 0));
        boxs[23].getTransforms().add(new Translate(2, -2, 0));
        boxs[24].getTransforms().add(new Translate(-2, -2, -2));
        boxs[25].getTransforms().add(new Translate(0, -2, -2));
        boxs[26].getTransforms().add(new Translate(2, -2, -2));
        boxs[25].setMaterial(new PhongMaterial(Color.BLUE));

        RotateBox(25, 50, 0);

        camera = new PerspectiveCamera(true);
        camera.isFixedEyeAtCameraZero();
        camera.getTransforms().add(new Translate(0, 0, -70));
        
        boxGroup.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event){
                System.out.println("x: " + event.getX());
                System.out.println("y: " + event.getY());
                System.out.println("z: " + event.getZ() + "\n");
            }
        });
        
        boxGroup.rotateProperty().bind(slider.valueProperty());
    }

    public void translateLight(int x, int y, int z) {
        light.setTranslateX(x);
        light.setTranslateY(y);
        light.setTranslateZ(z);
    }

    public void RotateBox(int x, int y, int z) {
        boxGroup.getTransforms().addAll(
                new Rotate(x, Rotate.Y_AXIS),
                new Rotate(y, Rotate.X_AXIS),
                new Rotate(z, Rotate.Z_AXIS));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        translateLight(-20, -20, -20);
        Group root = new Group();
        root.getChildren().add(boxGroup);
        //root.getChildren().add(light);
        root.getChildren().add(slider);
        //root.getChildren().add(tField);
        SubScene subScene = new SubScene(root, 1300, 800);
        subScene.setFill(Color.color(0.2, 0.2, 0.2, 1.0));
        subScene.setFill(Color.BISQUE);
        //subScene.setCamera(camera);
        Group group = new Group();
        group.getChildren().add(subScene);

        primaryStage.setResizable(false);
        //Scene scene = new Scene(group);
        Scene scene = new Scene(root, 1300, 800);
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("ThreeDimPractice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void mouseListener() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.print("鼠标点击----" + "\t");
        if (e.getClickCount() == 1) {
            System.out.println("单击！");
        } else if (e.getClickCount() == 2) {
            System.out.println("双击！");
        } else if (e.getClickCount() == 3) {
            System.out.println("三连击！！");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("鼠标松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        tField.setText("鼠标已经进入窗体");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        tField.setText("鼠标已经移出窗体");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        String string = "鼠标拖动到位置：（" + e.getX() + "，" + e.getY() + "）";
        tField.setText(string);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
