/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeatingChart;

/**
 *
 * @author 44869
 */
public class Seat {

    Student[] s;
    Student[][] seat;
    int count = 0;

    Seat() {
        s = new Student[16];
        seat = new Student[4][4];
    }

    public void add(Student s) {
        if (count < this.s.length) {
            this.s[count] = s;
            count++;
        } else {
            System.out.println("Out of range");
        }
    }

    public void bubbleSortMethod(Student[] s) {
        Student temp;
        int i, len = s.length;
        boolean changed;
        do {
            changed = false;
            len -= 1;
            for (i = 0; i < len; i++) {
                if (s[i] != null && s[i + 1] != null) {
                    if (s[i].getName().compareTo(s[i + 1].getName()) > 1) {
                        temp = s[i];
                        s[i] = s[i + 1];
                        s[i + 1] = temp;
                        changed = true;
                    }
                }
            }
        } while (changed);
    }

    public void sortAlpha() {
        bubbleSortMethod(s);
        int num = 0;
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[0].length; j++) {
                seat[i][j] = s[num];
                num++;
            }
        }
    }

    public void Alternating() {
        Student[] m = new Student[s.length], f = new Student[s.length];
        int nm = 0, nf = 0, num = 0;
        for (int i = 0; i < f.length; i++) {
            if (s[i] != null) {
                if (s[i].gender.equals("M")) {
                    m[nm] = s[i];
                    nm++;
                } else if (s[i].gender.equals("F")) {
                    f[nf] = s[i];
                    nf++;
                }
            }
        }
        nm = 0;
        nf = 0;
        for (int i = 0; i < f.length; i += 2) {
            s[i] = m[nm];
            nm++;
        }
        for (int i = 1; i < f.length; i += 2) {
            s[i] = f[nf];
            nf++;
        }
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[0].length; j++) {
                seat[i][j] = s[num];
                num++;
            }
        }
    }

    public void random() {
        Student[] temp = new Student[16], s2 = new Student[16];
        int num = 0;
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[i];
            if (s[i] != null) {
                num++;
            }
        }
        for (int j = 0; j < s2.length; j++) {
            int randomNum = (int) (Math.random() * (num - 1 + 1) + 1) - 1;
            System.out.println(randomNum);
            s2[j] = temp[randomNum];
            if (num > 0) {
                num--;
            }
            for (int k = randomNum; k < (temp.length - 1); k++) {
                temp[k] = temp[k + 1];
            }
        }
        num = 0;
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[0].length; j++) {
                seat[i][j] = s2[num];
                num++;
            }
        }
    }

    public void print() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[0].length; j++) {
                if (seat[i][j] != null) {
                    System.out.print(seat[i][j].getName() + "(" + seat[i][j].getGender() + ")" + "\t\t");
                } else {
                    System.out.print("null\t\t\t");
                }
            }
            System.out.println("");
        }
    }
}
