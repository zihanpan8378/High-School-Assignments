/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadiobuttonCheckbox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class Example1 extends Application {

    double total = 0;

    RadioButton rb1, rb2, rb3;
    final ToggleGroup radGroup = new ToggleGroup();

    ToggleButton bt1, bt2, bt3;
    final ToggleGroup buttGroup = new ToggleGroup();

    Label lblSize, lblPizza, lblTotal;
    CheckBox ch1, ch2, ch3;

    GridPane pane;
    HBox hb1;

    public Example1() {
        rb1 = new RadioButton("Small");
        rb1.setToggleGroup(radGroup);
        rb1.setSelected(true);
        rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(radGroup);
        rb3 = new RadioButton("Large");
        rb3.setToggleGroup(radGroup);

        bt1 = new ToggleButton("Thin");
        bt1.setToggleGroup(buttGroup);
        bt2 = new ToggleButton("Original");
        bt2.setToggleGroup(buttGroup);
        bt3 = new ToggleButton("Thick");
        bt3.setToggleGroup(buttGroup);

        lblSize = new Label();
        lblPizza = new Label();
        lblTotal = new Label();

        ch1 = new CheckBox("Drink, $1.50");
        ch2 = new CheckBox("Fries, $3.00");
        ch3 = new CheckBox("Pie, $2.50");

        pane = new GridPane();
        hb1 = new HBox();

    }

    @Override
    public void start(Stage primaryStage) {

        radGroup.selectedToggleProperty().addListener(e -> radioGroup());
        buttGroup.selectedToggleProperty().addListener(e -> buttGroup());

        ch1.selectedProperty().addListener(e -> ch1());
        ch2.selectedProperty().addListener(e -> ch2());
        ch3.selectedProperty().addListener(e -> ch3());

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();
        ColumnConstraints c4 = new ColumnConstraints();

        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getColumnConstraints().addAll(c1, c2, c3, c4);

        pane.addRow(2, rb1, ch1);
        pane.addRow(3, rb2, ch2);
        pane.addRow(4, rb3, ch3);
        pane.addRow(5, lblSize);

        hb1.setSpacing(10.0);
        hb1.getChildren().addAll(bt1, bt2, bt3);

        lblTotal.setText(String.valueOf(total));

        pane.addRow(6, hb1);
        pane.addRow(7, lblPizza);
        pane.addRow(8, lblTotal);

        Scene scene = new Scene(pane, 700, 400);
        primaryStage.setTitle("Pizza Order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void radioGroup() {
        rb1.setUserData(8.00);
        rb2.setUserData(11.00);
        rb3.setUserData(13.00);
        if (radGroup.getSelectedToggle() != null) {
            lblSize.setText(radGroup.getSelectedToggle().getUserData().toString());
        }
        total = Double.parseDouble(lblSize.getText());
        lblTotal.setText(String.valueOf(total));
    }

    private void buttGroup() {
        bt1.setUserData("Thin");
        bt2.setUserData("Original");
        bt3.setUserData("Thick");
        if (buttGroup.getSelectedToggle() != null) {
            lblPizza.setText(buttGroup.getSelectedToggle().getUserData().toString());
        }
    }

    private void ch1() {
        if (ch1.isSelected()) {
            ch1.setUserData(1.5);
            total += Double.parseDouble(ch1.getUserData().toString());
        } else {
            total -= Double.parseDouble(ch1.getUserData().toString());
        }
        lblTotal.setText(String.valueOf(total));
        System.out.println("Total: " + total);
    }

    private void ch2() {
        if (ch2.isSelected()) {
            ch2.setUserData(3.0);
            total += Double.parseDouble(ch2.getUserData().toString());
        } else {
            total -= Double.parseDouble(ch2.getUserData().toString());
        }
        lblTotal.setText(String.valueOf(total));
        System.out.println("Total: " + total);
    }

    private void ch3() {
        if (ch2.isSelected()) {
            ch2.setUserData(2.5);
            total += Double.parseDouble(ch2.getUserData().toString());
        } else {
            total -= Double.parseDouble(ch2.getUserData().toString());
        }
        lblTotal.setText(String.valueOf(total));
        System.out.println("Total: " + total);
    }

}
