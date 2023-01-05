/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

/**
 *
 * @author 44869
 */
public class Teacher extends Person{
    private String subject, classroom;
    
    
    public Teacher(String name, int age, String subject, String classroom){
        super(name, age);
        this.subject = subject;
        this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return super.toString() + "\nsubject: " + subject + "\nclassroom: " + classroom;
    }
}

class testTeacher{
    public static void main(String[] args) {
        Teacher t1 = new Teacher("M", 40, "English", "C9");
        System.out.println(t1);
    }
}
