/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b08_producter_consumer;

/**
 *
 * @author nvmin
 */
public class Producter extends Thread{
    private int id;
    private Buffer buffer;

    public Producter(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            if(buffer.getCapacity() > buffer.getSize()) {
                try {
                    buffer.addProduct(i++, this.id);
                    sleep((long) (Math.random()*1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
