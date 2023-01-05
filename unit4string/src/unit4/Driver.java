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
public class Driver {
    public static void main(String[] args) {
		CollegeGroup ricky = new CollegeGroup();
		ricky.addColleges();
		System.out.println(ricky);
		ricky.updateTuition("Florida", 1);
		System.out.println(ricky);
		String result = "";
		int p = ricky.getCollegeList("Northeast", 20000, 30000).length;
		College[] rick = new College[p];
		for (int j = 0; j < p; j++) {
			rick[j] = ricky.getCollegeList("Northeast", 20000, 30000)[j];
		}

		for (int i = 0; i < p; i++) {
			result += rick[i].getName() + " " + rick[i].getRegion() + " " + rick[i].getTuition() + "\n";
		}
		System.out.println(result);

	}
}
