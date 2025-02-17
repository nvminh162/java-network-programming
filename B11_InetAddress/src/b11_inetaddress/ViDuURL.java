/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_inetaddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author nvmin
 */
public class ViDuURL {
    public static void main(String[] args) {
        try {
            //Tạo đối tượng URL
            String urlString = "https://vi.wikipedia.org/wiki/Vi%E1%BB%87t_Nam";
            URL url = new URL(urlString);
            //Đọc dữ liệu
            InputStreamReader is = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(is);
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
