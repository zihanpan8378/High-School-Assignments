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
public class Name3 {

    String Lastname;

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getGroup() {
        if ("ABCDEFGHI".contains(Lastname.substring(0, 1))) {
            return "Group1";
        }
        if ("JLKMNOPQR".contains(Lastname.substring(0, 1))) {
            return "Group2";
        } else {
            return "Group3";
        }
    }

}
