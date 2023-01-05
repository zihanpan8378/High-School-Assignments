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
public class testFormative2review {
    public static void main(String[] args) {
		Formative2review myNums = new Formative2review();
                	myNums.setCount(20);
		myNums.setUserInfo();
                
                System.out.println("The average of the numbers entered: " + myNums.getAverage());
		System.out.println("The maximum number entered is: " + myNums.getMaximum());
		System.out.println("The values have a range: " + myNums.getRange());
                System.out.println("The lowest most number is: " + myNums.getMostNumber());
		//System.out.println("The median value is: " + myNums.getMedian());
		System.out.println("A histogram of the data appears like:");
		myNums.setHistogram();
	}
}



