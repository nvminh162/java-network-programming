/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b14_client;

import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author nvmin
 */
public class ClientListener implements Runnable {
    private Socket socket;
    private InputStream inputStream;

    public ClientListener(Socket socket) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead=inputStream.read(buffer)) != -1) {                
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
