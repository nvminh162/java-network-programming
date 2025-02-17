/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author nvmin
 */
public class MyPrintWriter {

    public static void main(String[] args) {
        PrintWriter pw = null;
        String text = "Xin chào - tạm biệt!";
        try {
            pw = new PrintWriter(new FileOutputStream("src/javaio/data.txt"));
            pw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
