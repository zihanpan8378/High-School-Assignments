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
public class Name4 {

    String Fullname, Firstname, Lastname, Middlename;
    int Num;

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public void setFirstname() {
        this.Firstname = Fullname.substring(0, (Fullname.indexOf(" ")));
        
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setMiddlename() {
        this.Middlename = Fullname.substring((Fullname.indexOf(" ") + 1), (Fullname.lastIndexOf(" ")));
        
    }

    public String getMiddlename() {
        return Middlename;
    }

    public void setLastname() {
        this.Lastname = Fullname.substring((Fullname.lastIndexOf(" ") + 1));
        
    }

    public String getLastname() {
        return Lastname;
    }

    public String getMonogram() {       
        return Firstname.substring(0, 1).toLowerCase() + Middlename.substring(0, 1).toUpperCase() + Lastname.substring(0, 1).toLowerCase();
    }

}
