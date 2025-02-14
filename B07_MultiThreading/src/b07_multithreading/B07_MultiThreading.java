/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b07_multithreading;

/**
 *
 * @author nvmin
 */
public class B07_MultiThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main");
        
        Thread th = new TaskA();
        th.start();
        
        Thread th2 = new Thread(new TaskB());
        th2.start();
        
        
        System.out.println("Kết thúc Main");
    }
    
}
