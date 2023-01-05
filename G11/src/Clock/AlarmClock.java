/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;
/**
 *
 * @author 44869
 */
public class AlarmClock extends Clock{
    int ah, am;
    
    public AlarmClock(int h, int m, int ah, int am){
        super(h, m);
        this.am = am;
        this.ah = ah;
    }
    
    public void setDefaultAlarm(){
        ah = 5;
        am = 0;
    }
    
    @Override
    public void advance(){
        super.advance();
        if(super.getHours()==ah&&super.getMins()==am){
            System.out.println("Alarm!");
        }else{
            setDefaultAlarm();
        }
    }
    
}