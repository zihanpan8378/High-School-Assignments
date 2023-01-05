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
public class CollegeGroup {
    private College[] myColleges; // myColleges.length is # colleges

	public CollegeGroup() {
		int numColleges = 7;
		myColleges = new College[numColleges];
		addColleges();
	}

	public void addColleges() {
		myColleges[0] = new College("Colgate", "Northeast", 27025);
		myColleges[1] = new College("Duke", "Southeast", 26000);
		myColleges[2] = new College("Kalamazoo", "Midwest", 19764);
		myColleges[3] = new College("Stanford", "West", 25917);
		myColleges[4] = new College("Florida", "Southeast", 10800);
		myColleges[5] = new College("Dartmouth", "Northeast", 27764);
		myColleges[6] = new College("Spelman", "Southeast", 11455);
	}

	public String toString() {
		String result = "";

		for (int i = 0; i < myColleges.length; i++)
			result += myColleges[i].getName() + " " + myColleges[i].getRegion() + " " + myColleges[i].getTuition()
					+ "\n";
		return result;
	}

	public void updateTuition(String collegeName, int newTuition) {  
    	

    	    }

	public College[ ] getCollegeList(String region, int low, int high) {
    	
    	}


}
