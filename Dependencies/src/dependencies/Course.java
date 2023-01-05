/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencies;

/**
 *
 * @author 44869
 */
public class Course {
    String courseName;
    String courseID;
    int credits;

    public Course(String courseName, String courseID, int credits) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" + "courseName=" + courseName + ", courseID=" + courseID + ", credits=" + credits + '}';
    }
    
}
