/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b12_socket;

import java.net.Socket;

/**
 *
 * @author nvmin
 */
public class PortScanner {
    public static void main(String[] args) {
        checkPort("www.vnexpress.net");
    }
    
    public static void checkPort(String urlString) {
        int startPort = 1;
        int endPort = 65535;
        
        System.out.println("Đang quét các port của máy: "+urlString);
        
        for(int i = startPort; i <= endPort; i++) {
            try {
                Socket socket = new Socket(urlString, i);
                System.out.println("Port : "+ i + " đang mở");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Quét cổng hoàn tất!");
    }
}
