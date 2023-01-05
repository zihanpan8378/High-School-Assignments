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
public class Staff extends UEmployee{
    private String jobTitle;
    
    public Staff(String n, double s, String j){
        super(n, s);
        jobTitle = j;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return super.toString() + "job title: " + jobTitle;
    }
    
}

class testStaff{
    public static void main(String[] args) {
        Staff f = new Staff("pan", 2333, "erdengbing");
        System.out.println(f);
    }
}
