package Lab_6_Ishan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class chatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7000);
            System.out.println("Connected to chat server...");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Thread to read messages from server
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception ignored) {}
            }).start();

            // Sending messages to server
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msg = scanner.nextLine();
                out.println(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
