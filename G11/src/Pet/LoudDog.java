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
public class LoudDog extends Dog{//1
    public LoudDog(String name){
        super(name);
    }
    @Override
    public String speak(){
        String s = super.speak();//1
        return s + s;//1
    }
}
