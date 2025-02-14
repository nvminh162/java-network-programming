/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b10_qltv;

/**
 *
 * @author nvmin
 */
public class Book {
    private String title;
    private String author;
    private boolean availabe;

    public Book(String title, String author, boolean availabe) {
        this.title = title;
        this.author = author;
        this.availabe = availabe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailabe() {
        return availabe;
    }

    public void setAvailabe(boolean availabe) {
        this.availabe = availabe;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", availabe=" + availabe + '}';
    }
}
