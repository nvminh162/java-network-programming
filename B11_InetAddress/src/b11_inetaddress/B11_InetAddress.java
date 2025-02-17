/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b11_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author nvmin
 */
public class B11_InetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        String domain = "www.google.com";
        InetAddress address = InetAddress.getByName(domain);
        System.out.println("Tên miền: :" + domain);
        System.out.println("IP: :" + address.getHostAddress());
        
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Address localhost: "+localhost.getHostAddress());
    }
    
}
