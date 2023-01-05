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
public class UEmployee {
    private String name;
    private double salary;
    
    public UEmployee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public UEmployee(){
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UEmployee:" + "\nname=" + name + "\nsalary=" + salary + "\n";
    }
    
}
