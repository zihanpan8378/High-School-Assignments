/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultipleButtons_OneD;

/**
 *
 * @author 44869
 */
public class OneTwoThreeFour {
    int[] data = {999, 1, 1, 1, 1};
    int[] buttons1 = new int[4], buttons2 = new int[4];
    int num1, num2, score = 0;
    boolean result;
    
    public void generate() {
        for (int i = 0; i < buttons1.length; i++) {
            int random = (int) (Math.random() * 4 + 1);
            while (data[random] == 0) {
                random = (int) (Math.random() * 4 + 1);
            }
            buttons1[i] = random;
            data[random]--;
        }
        
        for (int i = 0; i < buttons1.length; i++) {
            int random = (int) (Math.random() * 4 + 1);
            while (data[random] == 1) {
                random = (int) (Math.random() * 4 + 1);
            }
            buttons2[i] = random;
            data[random]++;
        }
    }
    
    public void check() {
        if(num1 == num2) {
            result = true;
            score++;
        } else {
            result = false;
        }
    }
    
}
