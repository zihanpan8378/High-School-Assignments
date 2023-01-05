/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UEmployee;

/**
 *
 * @author 44869
 */
public class Faculty extends UEmployee {
    private String department;
    
    public Faculty(String n, double s, String d){
        super(n, s);
        department = d;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "department: " + department;
    }
    
}

class testFaculty{
    public static void main(String[] args) {
        Faculty f = new Faculty("pan", 2333, "chi");
        System.out.println(f);
    }
}
