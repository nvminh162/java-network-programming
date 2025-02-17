/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaio;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author nvmin
 */
public class MyBufferedWriter {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        String data = "Chào các bạn ..................";
        try {
            bw = new BufferedWriter(new FileWriter("src/javaio/data.txt"));
            bw.write(data);
        } catch (Exception e) {
        } finally {
            try {
                bw.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
