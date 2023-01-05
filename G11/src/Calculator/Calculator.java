/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author 44869
 */
public interface Calculator {   
    public void setA(double a);	//sets the value of the first operand
    public void setB(double b); 	//sets the value of the second operand
    public double getA(); 		//returns the value of the first operand
    public double getB(); 		//returns the value of the second operand
    public double getResult(); 	//returns the value after performing a calculation        
}

