/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketThread;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44485
 */
public class ThreadTest {
    ArrayList<Integer> h = new ArrayList();
    
    public void test2(){
        for (int i = 0; i < 10; i++) {
            
            h.add(i);
        }
        for (int i = 0; i < h.size(); i++) {
            
            System.out.println(h.get(i));
        }
        for (int i = 0; i < h.size(); i++) {
            h.remove(i);
        }
    }
    public void test(){
        new Thread(new Runnable() {
                @Override
                public void run() {
                    int i=0;
                    while(i<10){
                        System.out.println(i);
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }).start();
    }
}
class test{
    public static void main(String[] args) {
        ThreadTest tt=new ThreadTest();
        tt.test2();
    }
    
}