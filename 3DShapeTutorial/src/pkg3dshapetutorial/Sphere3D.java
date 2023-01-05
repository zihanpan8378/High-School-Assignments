/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dshapetutorial;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
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
public class Sphere3D extends Application {
 
  private static final int WIDTH = 1400;
  private static final int HEIGHT = 800;
 
  @Override
  public void start(Stage primaryStage) {
    Sphere sphere = new Sphere(100);//初始化sphere

    Group group = new Group();
    group.getChildren().add(sphere);
 
    Camera camera = new PerspectiveCamera();
    Scene scene = new Scene(group, WIDTH, HEIGHT);//设定scene大小
    scene.setFill(Color.SILVER);//设定背景颜色
    scene.setCamera(camera);//添加camera
 
    //调整物体位置（xy轴平移）
    sphere.translateXProperty().set(WIDTH / 2);
    sphere.translateYProperty().set(HEIGHT / 2);
 
    //键盘监听事件（W - z轴向前；S - z轴向后）
    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
      switch (event.getCode()) {
        case W:
          sphere.translateZProperty().set(sphere.getTranslateZ() + 50);
          break;
        case S:
          sphere.translateZProperty().set(sphere.getTranslateZ() - 50);
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