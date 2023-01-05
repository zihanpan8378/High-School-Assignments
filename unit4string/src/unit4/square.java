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
public class square {
    int[] num = {1,2,3,4,5,6,7,8,9,10};
    
    public int[] getNum() {
        return num;
    }

    /*public void setNum(int[] num) {
        this.num = num;      
    }*/
    
    public int[] getSqu() {
        int[] squ = new int[10];
        for(int i=0;i<squ.length;i++){
            squ[i] = num[i]*num[i];
        }
        return squ;
    }
}
