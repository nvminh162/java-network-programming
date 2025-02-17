/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b14_server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author nvmin
 */
public class ClientHandler implements Runnable {
    private int id;
    private Socket socket;
    private ServerChat serverChat;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientHandler(int id, Socket socket, ServerChat serverChat) {
        this.id = id;
        this.socket = socket;
        this.serverChat = serverChat;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerChat getServerChat() {
        return serverChat;
    }

    public void setServerChat(ServerChat serverChat) {
        this.serverChat = serverChat;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                serverChat.broadcastMessage(id, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            outputStream.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
