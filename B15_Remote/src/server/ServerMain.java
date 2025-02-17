/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author nvmin
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Open server with port 5000");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                //Tạo luồng thực thi
                Thread thread = new Thread(
                        () -> handleClientRequest(socket)
                );
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleClientRequest(Socket socket) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            while (true) {
                String request = br.readLine();
                System.out.println(request);
                if (request.equals("shutdown")) {
                    //Runtime 
                    Runtime.getRuntime().exec("shutdown -s -t 3600");
                    pw.println("This PC turning off...");
                    pw.flush();
                } else if (request.equals("restart")) {
                    Runtime.getRuntime().exec("shutdown -r -t 3600");
                    pw.println("This PC turning restart...");
                    pw.flush();
                } else if (request.equals("cancel")) {
                    Runtime.getRuntime().exec("shutdown -a");
                    pw.println("Cancel success...");
                    pw.flush();
                } else if(request.equals("screenshot")){
                    // Chụp ảnh
                    BufferedImage screenshot = new Robot().createScreenCapture(
                            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
                    );
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "png", baos);
                    
                    byte[] imageBytes = baos.toByteArray();
                    baos.close();
                    
                    pw.println(imageBytes.length);
                    pw.flush();
                    socket.getOutputStream().write(imageBytes);
                } else if (request.equals("titv")) {
                    Runtime.getRuntime().exec("cmd /c start chrome https://titv.vn");
                    pw.println("success...");
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
