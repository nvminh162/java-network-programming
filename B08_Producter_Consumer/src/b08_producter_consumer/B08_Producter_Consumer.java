/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b08_producter_consumer;

/**
 *
 * @author nvmin
 */
public class B08_Producter_Consumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Producter p1 = new Producter(333, buffer);
        Consumer c1 = new Consumer(001, buffer);
        
        p1.start();
        c1.start();
        
    }
    
}
