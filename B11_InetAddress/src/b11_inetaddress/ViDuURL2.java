/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_inetaddress;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author nvmin
 */
public class ViDuURL2 {
    public static void main(String[] args) {
        String[] websites = {
            "https://titv.vn",
            "https://google.com",
            "https://vnexpress.net0",
        };
        for (String website : websites) {
            checkWebsite(website);
        }
        
    }
    
    public static void checkWebsite(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();
            if(responseCode==200) {
                System.out.println("Web đang HĐ: "+urlString);
            } else {
                System.out.println("Web không HĐ, mã code: "+responseCode);
            }
        } catch (Exception e) {
            System.out.println("Không thể kết nối: "+urlString);
        }
    }
}
