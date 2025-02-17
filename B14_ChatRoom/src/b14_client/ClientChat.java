/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b14_client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nvmin
 */
public class ClientChat {

    private static final int PORT = 5000;
    private static final String URL = "localhost";

    public void start() {
        Scanner sc = new Scanner(System.in);
        try {
            Socket socket = new Socket(URL, PORT);
            System.out.println("Connected to server on Port: " + PORT);

            ClientListener clientListener = new ClientListener(socket);
            new Thread(clientListener).start();
            
            OutputStream os = socket.getOutputStream();
            while (true) {                
                String message = sc.nextLine();
                os.write(message.getBytes());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Can't connect to server!");
        }
    }
}
