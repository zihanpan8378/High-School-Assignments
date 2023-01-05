/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class percentage {
    int Grade;
    String LetterGrade;
    
    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }
    public String getLetterGrade() {
        if (getGrade() <= 100 && getGrade() >= 90) {
            LetterGrade = "A";
        } else  if (getGrade() <= 89 && getGrade() >= 80) {
            LetterGrade = "B";
        } else  if (getGrade() <= 79 && getGrade() >= 70) {
            LetterGrade = "C";
        } else  if (getGrade() <= 69 && getGrade() >= 60) {
            LetterGrade = "D";
        }
        else  if (getGrade() <= 60) {
            LetterGrade = "F";
        }
        return LetterGrade;
    
}
