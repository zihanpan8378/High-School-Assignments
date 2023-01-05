/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualfx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class MoveCharacter extends Application {

    private static final double W = 600, H = 400;
    private Image heroImage;
    private Node hero;
    boolean run = false, goNorth = false, goSouth = false, goWest = false, goEast = false;

    @Override
    public void start(Stage primaryStage) {
        hero = new ImageView(new Image("http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png"));
        Group g = new Group(hero);

        moveHeroTo(W / 2, H / 2);

        Scene scene = new Scene(g, W, H, Color.FORESTGREEN);

        scene.setOnKeyPressed(sceneOnKeyPressed);
        scene.setOnKeyReleased(sceneOnKeyReleased);

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) {
                    dy -= 1;
                }
                if (goSouth) {
                    dy += 1;
                }
                if (goWest) {
                    dx -= 1;
                }
                if (goEast) {
                    dx += 1;
                }
                if (run) {
                    dx *= 3;
                    dy *= 3;
                }

                moveHeroBy(dx, dy);
            }
        };
        timer.start();
    }

    EventHandler<KeyEvent> sceneOnKeyPressed = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.UP) {
                goNorth = true;
            } else if (event.getCode() == KeyCode.DOWN) {
                goSouth = true;
            } else if (event.getCode() == KeyCode.LEFT) {
                goWest = true;
            } else if (event.getCode() == KeyCode.RIGHT) {
                goEast = true;
            } else if (event.getCode() == KeyCode.SHIFT) {
                run = true;
            }
        }
    };

    EventHandler<KeyEvent> sceneOnKeyReleased = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.UP) {
                goNorth = false;
            } else if (event.getCode() == KeyCode.DOWN) {
                goSouth = false;
            } else if (event.getCode() == KeyCode.LEFT) {
                goWest = false;
            } else if (event.getCode() == KeyCode.RIGHT) {
                goEast = false;
            } else if (event.getCode() == KeyCode.SHIFT) {
                run = false;
            }
        }
    };

    private void moveHeroBy(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }

        final double cx = hero.getBoundsInLocal().getWidth() / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;

        double x = cx + hero.getLayoutX() + dx;
        double y = cy + hero.getLayoutY() + dy;

        moveHeroTo(x, y);
    }

    private void moveHeroTo(double x, double y) {
        final double cx = hero.getBoundsInLocal().getWidth() / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0
                && x + cx <= W
                && y - cy >= 0
                && y + cy <= H) {
            hero.relocate(x - cx, y - cy);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
