/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

/**
 *
 * @author 44869
 */
public class Test {
    public static void main(String[] args) {
      show(new Cat_());  // 以 Cat 对象调用 show 方法
      show(new Dog_());  // 以 Dog 对象调用 show 方法
                
      Animal a = new Cat_();  // 向上转型  
      a.eat();               // 调用的是 Cat 的 eat
      Cat_ c = (Cat_)a;        // 向下转型  
      c.work();        // 调用的是 Cat 的 work
  }  
            
    public static void show(Animal a)  {
      a.eat();  
        // 类型判断
        if (a instanceof Cat_)  {  // 猫做的事情 
            Cat_ c = (Cat_)a;  
            c.work();  
        } else if (a instanceof Dog_) { // 狗做的事情 
            Dog_ c = (Dog_)a;  
            c.work();  
        }  
    }  
}
 
abstract class Animal {  
    abstract void eat();  
}  
  
class Cat_ extends Animal {  
    public void eat() {  
        System.out.println("吃鱼");  
    }  
    public void work() {  
        System.out.println("抓老鼠");  
    }  
}  
  
class Dog_ extends Animal {  
    public void eat() {  
        System.out.println("吃骨头");  
    }  
    public void work() {  
        System.out.println("看家");  
    }  
}
