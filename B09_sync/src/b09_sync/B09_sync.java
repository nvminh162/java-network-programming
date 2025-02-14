/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b09_sync;

/**
 *
 * @author nvmin
 */
public class B09_sync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        counter.increament();
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        counter.increament();
                    }
                }
        );

        t1.start();
        
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(counter.getCount());
    }

}
