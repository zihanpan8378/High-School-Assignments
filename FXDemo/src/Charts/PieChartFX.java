/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

/**
 *
 * @author 46505
 */
public class PieChartFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Chart Numero 1");
        stage.setWidth(500);
        stage.setHeight(500);

        //Pie chart data and titles
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Apple Pie", 13),
                        new PieChart.Data("Blue Berry Pie", 25),
                        new PieChart.Data("Tart Pie", 10),
                        new PieChart.Data("Fruit Pie", 22));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Cool Pie Chart");

//        Label size and placement
        chart.setLabelLineLength(10);
        chart.setLegendSide(Side.LEFT);

        //orientation of the chart
//        chart.setClockwise(false);
//        chart.setStartAngle(180);
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
