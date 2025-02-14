/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b10_qltv;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nvmin
 */
public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public /* synchronized */ void addBook(Book b) {
        books.add(b);
        System.out.println(">>> Add book: " + b.getTitle());
    }

    public synchronized void borrowBook(long id, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if(book.isAvailabe()) {
                    book.setAvailabe(false);
                    System.out.println(id+": <<< Borrowed book: "+title);
                    return;
                }
            }
        }
        System.out.println(id+": *** Can't borrow book!: "+title);
    }
    
    public synchronized void returnBook(long id, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if(!book.isAvailabe()) {
                    book.setAvailabe(true);
                    System.out.println(id+": >>> return book: "+title);
                    return;
                }
            }
        }
        System.out.println(id+": *** Can't return book!: "+title);
    }
    
    public void displayBooks() {
        System.out.println("Library book: ");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
