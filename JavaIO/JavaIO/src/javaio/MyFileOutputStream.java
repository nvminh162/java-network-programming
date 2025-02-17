/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.FileOutputStream;

/**
 *
 * @author nvmin
 */
public class MyFileOutputStream {
//    public static void main(String[] args) {
//        String text = "Xin chào";
//        byte[] myBytes = text.getBytes();
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("src/javaio/write.txt");
//            for(byte temp : myBytes) {
//                fos.write(temp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fos.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        
//    }

    public static void main(String[] args) {
        String text = "Xin chào";
        byte[] myBytes = text.getBytes();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/javaio/data.txt");
            fos.write(myBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
