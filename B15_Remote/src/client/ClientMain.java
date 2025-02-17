/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author nvmin
 */
public class ClientMain {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                System.out.println("MENU---");
                System.out.println("1. Shutdown");
                System.out.println("2. Restart");
                System.out.println("3. Cancel Shutdown/Restart");
                System.out.println("4. Screenshot");
                System.out.println("5. Open titv.vn");
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println("Choiced: " + choice);
                switch (choice) {
                    case 1:
                        pw.println("shutdown");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 2:
                        pw.println("restart");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 3:
                        pw.println("cancel");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 4:
                        pw.println("screenshot");
                        pw.flush();
                        int imageSize = Integer.parseInt(br.readLine());
                        byte[] imageBytes = new byte[imageSize];
                        int byteRead = socket.getInputStream().read(imageBytes);
                        if (byteRead > 0) {
                            System.out.println("Nhập tên ảnh: ");
                            String fileName = sc.nextLine();
                            Path imagePath = Paths.get(fileName + ".png");
                            Files.write(imagePath, imageBytes);
                            System.out.println("Done!");
                        }
                        break;
                    case 5:
                        pw.println("titv");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
