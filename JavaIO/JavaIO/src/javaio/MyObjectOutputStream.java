/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nvmin
 */
public class MyObjectOutputStream {
    public static void main(String[] args) {
        Student st1 = new Student("Minh", 21, 9.5);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/javaio/student.txt"));
            oos.writeObject(st1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
