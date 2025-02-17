/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b08_producter_consumer;

/**
 *
 * @author nvmin
 */
public class Consumer extends Thread {

    private int id;
    private Buffer buffer;

    public Consumer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            if (buffer.getSize() > 0) {
                try {
                    buffer.removeProduct(this.id);
                    sleep((long) (Math.random() * 1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
