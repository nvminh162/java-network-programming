/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b14_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nvmin
 */
public class ServerChat {

    private static final int PORT = 5000;
    private List<ClientHandler> clients = new ArrayList<>();
    
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("New connection, Listening on Port: " + PORT);
            
            while (true) {                
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: "+clientSocket.getInetAddress().getHostAddress());
                
                ClientHandler clientHandler = new ClientHandler((int) (Math.random()*1000), clientSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
        }
    }

    public void broadcastMessage(int id, String message) {
        for (ClientHandler client : clients) {
            if(!(client.getId()==id)) {
                client.sendMessage("("+id+") : "+message+".");
            }
        }
    }
}
