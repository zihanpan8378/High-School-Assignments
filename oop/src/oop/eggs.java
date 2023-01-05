/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author 44869
 */
public class eggs {
  double eggs;
  double baseprice;
  double dozen;  
  
  public void setEggs(double e) {
          eggs = e;
    }
  public void setBaseprice(double b) {
        baseprice = b = 0.5*dozen;
  }
  public void setDozen(double d) {
        dozen = d = eggs/12;
  }
  public double getPrice() {
     if(eggs<=48 && eggs>0)
        return baseprice;
     
     else if(eggs<=72 && eggs>=49)
        return baseprice - (0.5-0.45)*dozen;
     
     else if(eggs<=132 && eggs>=73)
        return baseprice - (0.5-0.4)*dozen;
     
     else if(eggs>=133)
        return baseprice - (0.5-0.35)*dozen;
     
        return 0;
  }
}
