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
public class Student extends Person {

    CourseGrade[] courses;

    public Student(String fName, String lName, CourseGrade[] cg) {
        super(fName, lName);
        courses = cg;
    }

    
}
