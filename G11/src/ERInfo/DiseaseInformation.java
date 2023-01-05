/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERInfo;

/**
 *
 * @author 44869
 */
public class DiseaseInformation {

    String name;
    int time;
    
    DiseaseInformation(String n, int t){
        name = n;
        time = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Disease name: " + getName()
                + "\nsTime to treat: " + getTime();
    }
    
}
