/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author nvmin
 */
public class MyObjectInputStream {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream("src/javaio/student.txt"));
            Student rsSt = (Student)ois.readObject();
            System.out.println(rsSt);
        } catch (Exception e) {
        }
    }
}
