/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author nvmin
 */
public class MyBufferedOutputStream {

    public static void main(String[] args) {
        String text = "Xin chào 23";
        byte[] myBytes = text.getBytes();

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream("src/javaio/data.txt");
            bos = new BufferedOutputStream(fos);

            bos.write(myBytes);
            bos.flush();
            
            System.out.println("Ghi file thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close(); // Đóng BufferedOutputStream
                }
                if (fos != null) {
                    fos.close(); // Đóng FileOutputStream
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
