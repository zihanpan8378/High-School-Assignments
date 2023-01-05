/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Space_Finder;

/**
 *
 * @author 44485
 */
public class NewClass {
    public static void main(String[] args) {
        int[] numbers={94,20,12,92,71,21};
        int mysteryNum=25;
        
        for(int i=0;i<numbers.length;i++){
            
            if(!(numbers[i]<=mysteryNum&&numbers[i]%2==1)){
                mysteryNum=numbers[i];
                System.out.println(mysteryNum);
            }
        }
        System.out.println(mysteryNum);
    }
}
