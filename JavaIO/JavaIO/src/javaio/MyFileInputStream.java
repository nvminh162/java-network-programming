/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

/**
 *
 * @author nvmin
 */
public class MyFileInputStream {
    //Doc file src/javaio/sample.txt
    public static void main(String[] args) {
        java.io.FileInputStream fis = null;
        try {
            fis = new java.io.FileInputStream("src/javaio/data.txt");
            System.out.println("Available byte: " + fis.available()); //lấy ra ký tự
            int myByte;
            while((myByte=fis.read()) != -1){
                System.out.print(myByte+" ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
