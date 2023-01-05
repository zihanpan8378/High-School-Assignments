/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JISEmployee;

/**
 *
 * @author 44869
 */
public abstract class JISEmployee {

    private String firstName, lastName;

    /**
     * Constructor pre: none post: A JISEmployee has been created
     */
    public JISEmployee(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    /**
     * Returns the employee's complete name.
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the employee pay based on period in weeks.
     */
    abstract double pay(double period);

    @Override
    public String toString() {
        return "JISEmployee\n" + getName() + ", ";
    }

}
