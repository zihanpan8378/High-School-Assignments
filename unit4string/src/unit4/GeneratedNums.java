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
public class GeneratedNums {

    int[] ind = new int[102], gen = new int[102];

    public void setInd() {
        for (int i = 0; i < 102; i++) {
            ind[i] = i;
        }
    }

    public void setGeneratedNum() {
        System.out.println("Index          GeneratedNumber");
        int n;
        for (int i = 0; i < 102; i++) {
            n = 0;
            double p = ind[i];
            while (p >= 1) {
                p = p / 10;
                n++;
            }
            int a = ind[i];

            for (int q = n - 1; q > 0; q--) {
                a = (int) (a / (Math.pow(10, q)));
                gen[i] += a;
                a = (int) (ind[i] % (Math.pow(10, q)));
            }
            gen[i] += ind[i] + ind[i] % 10;
            if (i < 10) {
                System.out.println(ind[i] + "         " + gen[i] + " " + n);
            } else if (i < 100) {
                System.out.println(ind[i] + "        " + gen[i] + " " + n);
            } else {
                System.out.println(ind[i] + "       " + gen[i] + " " + n);
            }
        }

    }
}
