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
public class Name2 {

    String Fullname, Firstname, Lastname;
    int Size;

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String FUllname) {
        this.Fullname = FUllname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getFirstname() {
        return Fullname.substring(0, (Fullname.indexOf(" ")));
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getLastname() {
        return Fullname.substring((Fullname.indexOf(" ")));
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }
    

}
