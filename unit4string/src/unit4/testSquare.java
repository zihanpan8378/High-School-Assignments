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
public class testSquare {
    public static void main(String[] args) {
        
        //Scanner in = new Scanner(System.in);
        square s = new square();
        int[] n = s.getNum();
        System.out.println("Index	Square");
        
        for(int i=0;i<n.length;i++){
            System.out.println(n[i] + "       " + s.getSqu()[i]);
        }
    }
}
