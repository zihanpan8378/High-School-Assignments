/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Charts;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author 46505
 */
public class StackedBarChartFX extends Application {

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc
            = new StackedBarChart<String, Number>(xAxis, yAxis);
    final XYChart.Series<String, Number> series1
            = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series2
            = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series3
            = new XYChart.Series<String, Number>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        sbc.setTitle("Country Summary");
        xAxis.setLabel("Country");
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(austria, brazil, france, italy, usa)));
        yAxis.setLabel("Value");
        series1.setName("2003");
        series1.getData().add(new XYChart.Data<String, Number>(austria, 25601.34));
        series1.getData().add(new XYChart.Data<String, Number>(brazil, 20148.82));
        series1.getData().add(new XYChart.Data<String, Number>(france, 10000));
        series1.getData().add(new XYChart.Data<String, Number>(italy, 35407.15));
        series1.getData().add(new XYChart.Data<String, Number>(usa, 12000));
        series2.setName("2004");
        series2.getData().add(new XYChart.Data<String, Number>(austria, 57401.85));
        series2.getData().add(new XYChart.Data<String, Number>(brazil, 41941.19));
        series2.getData().add(new XYChart.Data<String, Number>(france, 45263.37));
        series2.getData().add(new XYChart.Data<String, Number>(italy, 117320.16));
        series2.getData().add(new XYChart.Data<String, Number>(usa, 14845.27));
        series3.setName("2005");
        series3.getData().add(new XYChart.Data<String, Number>(austria, 45000.65));
        series3.getData().add(new XYChart.Data<String, Number>(brazil, 44835.76));
        series3.getData().add(new XYChart.Data<String, Number>(france, 18722.18));
        series3.getData().add(new XYChart.Data<String, Number>(italy, 17557.31));
        series3.getData().add(new XYChart.Data<String, Number>(usa, 92633.68));
        Scene scene = new Scene(sbc, 800, 600);
        sbc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
