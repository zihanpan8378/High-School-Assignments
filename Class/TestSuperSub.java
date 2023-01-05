/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author 44869
 */
class Super_Class {
  private int n;
  Super_Class(){
    System.out.println("SuperClass()");
  }
  Super_Class(int n) {
    System.out.println("SuperClass(int n)" + n);
    this.n = n;
  }
}
class Sub_Class extends Super_Class{
  private int n;
  
  Sub_Class(){
    super(301);
    System.out.println("SubClass");
  }  
  
  public Sub_Class(int n){
    System.out.println("SubClass(int n):"+n);
    this.n = n;
  }
}
public class TestSuperSub{
  public static void main (String args[]){
    //Sub_Class sc = new Sub_Class();
    Sub_Class sc2 = new Sub_Class(200); 
  }
}
