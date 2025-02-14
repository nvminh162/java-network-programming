/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b10_qltv;

/**
 *
 * @author nvmin
 */
public class Student extends Thread {
    private long id;
    private Library library;
    private String title;

    public Student(long id, Library library, String title) {
        this.id = id;
        this.library = library;
        this.title = title;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++) {
                library.borrowBook(id, title);
                sleep((long) (Math.random() * 1000));
                library.returnBook(id, title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
