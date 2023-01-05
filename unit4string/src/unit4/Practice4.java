/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 44869
 */
public class Practice4 {
    int[] num;
    String odd = "", even = "";

    public int[] getNum() {
        
        return num;
    }

    public void setNum() {
        num = new int[25];
        
        for(int i = 0;i<25;i++){
            num[i]=(int) (0+Math.random()*(99));
        }
    }
    
    public void setOddEven() {
        
        for(int i = 0;i<num.length;i++){
            if (num[i]%2 == 0){
                odd += num[i] + " ";
            }
            else {
                
                even += num[i] + " ";
            }
        }
        System.out.println("Evens");
        
            System.out.print(even);
        
        System.out.println("\n" + "Odds");
        
            System.out.print(odd);
        
    }
}
