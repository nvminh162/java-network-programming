/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.FileInputStream;
/**
 *
 * @author nvmin
 */
public class MyBufferedInputStream {
    public static void main(String[] args) {
        java.io.BufferedInputStream bis = null;
        try {
            bis = new java.io.BufferedInputStream(new FileInputStream("src/javaio/data.txt"));
            int myByte;
            while ((myByte = bis.read()) != -1) {
                System.out.print((char)myByte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
