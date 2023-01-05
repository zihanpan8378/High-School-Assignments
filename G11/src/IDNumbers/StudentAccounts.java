/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDNumbers;

import java.util.ArrayList;

/**
 *
 * @author 44869
 */
public class StudentAccounts {

    ArrayList<IDNumber> ids = new ArrayList();

    public StudentAccounts() {
        add(new IDNumber("John", "Von", "Neumann"));
        add(new IDNumber("Tim", "Walker", "Smith"));
        add(new IDNumber("Sean", "White", "Brown"));
    }

    public void add(IDNumber id) {
        int i;
        for (i = 0; i < ids.size(); i++) {
            if (ids.get(i).getID().equals(id.getID())) {
                id.getRandomID();
                i = 0;
            }
        }
        if (i == ids.size()) {
            ids.add(id);
        }
    }

    public void display(ArrayList<IDNumber> ids) {
        System.out.println("FName\tMName\tLName\tIDNumber");
        for (int i = 0; i < ids.size(); i++) {
            System.out.println(ids.get(i).getfName() + "\t"
                    + ids.get(i).getmName() + "\t"
                    + ids.get(i).getlName() + "\t"
                    + ids.get(i).getID());
        }
    }

    public void remove(String id) {
        int i;
        for (i = 0; i < ids.size(); i++) {
            if (ids.get(i).getID().equals(id)) {
                ids.remove(i);
                break;
            }
        }
        if (i == ids.size() + 1) {
            System.out.println("there isn't this ID!");
        }
    }

    public void edit(String id, int choice, String newName) {
        int i;
        for (i = 0; i < ids.size(); i++) {
            if (ids.get(i).getID().equals(id)) {
                break;
            }
        }
        if (i != ids.size()) {
            if (choice == 1) {
                ids.get(i).fName = newName;
            } else if (choice == 2) {
                ids.get(i).mName = newName;
            } else if (choice == 3) {
                ids.get(i).lName = newName;
            }
            ids.get(i).ID = ids.get(i).getRandomID();
        } else {
            System.out.println("there isn't this ID!!");
        }
    }

    public void boobleSort(ArrayList<IDNumber> list, int choice) {
        for (int i = 0; i < (list.size() - 1); i++) {
            for (int k = 1; k < (list.size() - i); k++) {
                boolean check = true;
                if (choice == 3) {
                    if (list.get(k - 1).lName.compareTo(list.get(k).lName) > 0) {
                        check = false;
                    }
                } else if (choice == 1) {
                    if (list.get(k - 1).fName.compareTo(list.get(k).fName) > 0) {
                        check = false;
                    }
                } else if (choice == 2) {
                    if (list.get(k - 1).mName.compareTo(list.get(k).mName) > 0) {
                        check = false;
                    }
                }
                if (check == false) {
                    IDNumber temp = list.get(k - 1);
                    list.set(k - 1, list.get(k));
                    list.set(k, temp);
                }
            }
        }
    }
}
