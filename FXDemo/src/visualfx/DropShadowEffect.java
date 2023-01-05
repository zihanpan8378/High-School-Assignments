/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 44280
 */
public class DropShadowEffect extends Application {
    
    @Override
    public void start(Stage stage) {
      Text text = new Text();        
      text.setFont(Font.font(null, FontWeight.BOLD, 40));        
      text.setX(60); 
      text.setY(50);  
      text.setText("Circle");        
      text.setFill(Color.DARKSEAGREEN);       
      Circle circle = new Circle();         
      circle.setCenterX(300.0f); 
      circle.setCenterY(160.0f); 
      circle.setRadius(100.0f); 
      DropShadow dropShadow = new DropShadow(); 
      dropShadow.setBlurType(BlurType.GAUSSIAN); 
      dropShadow.setColor(Color.ROSYBROWN); 
      dropShadow.setHeight(5); 
      
      //Setting the width of the shadow 
      dropShadow.setWidth(5); 
      
      //Setting the radius of the shadow 
      dropShadow.setRadius(5); 
      
      //setting the offset of the shadow 
      dropShadow.setOffsetX(3); 
      dropShadow.setOffsetY(2); 
      
      //Setting the spread of the shadow 
      dropShadow.setSpread(12);  
      
      //Applying shadow effect to the text 
      text.setEffect(dropShadow);      
      
      //Applying shadow effect to the circle 
      circle.setEffect(dropShadow); 
          
      //Creating a Group object   
      Group root = new Group(circle, text);   
               
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Drop Shadow effect example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
