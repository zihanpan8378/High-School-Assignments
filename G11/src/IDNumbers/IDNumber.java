/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDNumbers;

/**
 *
 * @author 44869
 */
public class IDNumber extends Student {

    String ID;

    public IDNumber(String fName, String mName, String lName) {
        super(fName, mName, lName);
        ID = getRandomID();
    }

    public String getID() {
        return ID;
    }

    public void setID() {
        //this.ID = getRandomID();
    }

    public String getShuffledNumber(int digit) {
        String shuffled = "";
        int random;
        for (int i = 0; i < digit; i++) {
            random = (int) (Math.random() * (4 - 1) + 1);
            shuffled += random;
        }
        return shuffled;
    }

    public String getRandomID() {
        String randomID = "";
        randomID += getShuffledNumber(3);
        randomID += super.getfName().substring(0, 1);
        randomID += super.getmName().substring(0, 1);
        randomID += super.getlName().substring(0, 1);
        return randomID;
    }
}
