/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom.ThreadLearning;

/**
 *
 * @author 44485
 */
public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;
    
    RunnableDemo(String name){
        threadName=name;
        System.out.println("creating "+threadName);
    }
    
    public void run(){
        System.out.println("Running "+threadName);
        try{
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: "+threadName+", "+i);
                Thread.sleep(50);
            }
           
        }catch(InterruptedException e){
            System.out.println("Thread "+threadName+" interrupted.");
        }
        System.out.println("Thread "+threadName+" exciting.");
    }
    
    public void start(){
        System.out.println("Starting "+ threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}

class TestThread{
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread -1");
        R1.start();
        
        RunnableDemo R2 =new RunnableDemo("Thread -2");
        R2.start();
    }
}
