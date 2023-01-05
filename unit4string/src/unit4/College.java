/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 44869
 */
public class College {
    String name;
    String region;
    int tuition;
    
    // constructors
    public College()
    {
        name = "";
        region = "";
        tuition = 0;
    }
    
    public College(String theName, String theRegion, int theTuition)
    {
        setName(theName);
        setRegion(theRegion);
        setTuition(theTuition);
    }
    
    // accessor methods
    public String getName( ) { return name; }
    public String getRegion( ) { return region;  }
    public int getTuition( ) { return tuition; }       

    // mutator methods
    public void setTuition(int newTuition) { tuition = newTuition;  }
    public void setName(String theName) { name = theName;  }
    public void setRegion(String theRegion) { region = theRegion;  }
}
