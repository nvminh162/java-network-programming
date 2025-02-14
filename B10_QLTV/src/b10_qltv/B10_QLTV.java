/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b10_qltv;

/**
 *
 * @author nvmin
 */
public class B10_QLTV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Jav1", "Nguyên1", true));
        library.addBook(new Book("Jav2", "Nguyên2", true));
        library.addBook(new Book("Jav3", "Nguyên3", true));
        library.addBook(new Book("Jav4", "Nguyên4", true));
        library.addBook(new Book("Jav5", "Nguyên5", true));

        Thread st1 = new Student(1, library, "Jav1");
        Thread st2 = new Student(2, library, "Jav1");
        Thread st3 = new Student(3, library, "Jav2");
        Thread st4 = new Student(4, library, "Jav2");
        
        st1.start();
        st2.start();
        st3.start();
        st4.start();
    }

}
