/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Formative2review {

    private int[] arr;
    private int arraySize;

    public void setCount(int s) { //sets the size of the array
        arraySize = s; // sets size to be the biggest number you can input
        arr = new int[arraySize + 1]; //allocates size + 1 spaces (why?)So that the user determines the space allocated instead of a fixed amount of memory
    }

    public void setUserInfo() {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter a number from 1 to " + (arr.length - 1) + " (" + -1 + " to end): ");
            n = input.nextInt();
            if (n != -1) {
                arr[n] += 1;
            }
        } while (n != -1); //allows user to input numbers to the array
    }

    public double getAverage() {
        int Sum = 0;
        int numberofInputs = 0;
        double average;

        for (int i = 1; i <= arraySize; i++) {
            Sum += i * arr[i];
            numberofInputs += arr[i];
        }
        average = (double) Sum / (double) numberofInputs;
        return average;
    }

    public int getMaximum() {
        int index = arraySize;

        while (arraySize > 0 && arr[index] == 0) {
            index--;
        }
        return index;
    }

    public int getRange() {
        int lowestNumber = 0;
        int highestNumber = 0;
        int index = 0;
        int r;

        while (index <= arraySize && arr[index] == 0) {
            index++;
        }
        lowestNumber = index;
        highestNumber = getMaximum();
        r = highestNumber - lowestNumber;
        return r;
    }

    public int getMostNumber() {
        int med = 0;
        int numValues = 0;

        for (int i = 0; i <= arraySize; i++) {
            if (arr[i] > numValues) {
                numValues = arr[i];
                med = i;
            }
        }
        return med;
    }

    void setHistogram() {
        for (int i = 0; i < arraySize; i++) {
            for (int q = 0; q < arr[i]; q++) {
                System.out.print("*");
            }
            System.out.println(i + ": ");
        }
        
    }

    /*public void getMedian() {
        int rangeCount = 0;
        for (int i = 1; i <= arraySize; i++) {
            rangeCount += arr[i];
            if (i % 5 == 0) {
                System.out.format(i - 4 + "\t" + i + " : ");
                setHistogram();
                rangeCount = 0;
            }
        }
    }*/
}
