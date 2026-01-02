package lab_8;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketChannelTimeClient {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            int port = 2000;
            InetAddress addr = InetAddress.getLocalHost();
            channel.connect(new InetSocketAddress(addr, port));

            System.out.println("Connected to Chat Server.");
            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                // Send message to server
                System.out.print("Client: ");
                String clientMsg = scanner.nextLine();
                buffer.clear();
                buffer.put(clientMsg.getBytes(StandardCharsets.UTF_8));
                buffer.flip();
                channel.write(buffer);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                // Read response from server
                buffer.clear();
                int bytesRead = channel.read(buffer);
                if (bytesRead == -1) break;

                buffer.flip();
                String serverMsg = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("Server: " + serverMsg);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server ended chat.");
                    break;
                }
            }

            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
