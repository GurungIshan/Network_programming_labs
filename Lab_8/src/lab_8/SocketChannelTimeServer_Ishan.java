package lab_8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class SocketChannelTimeServer_Ishan {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            int port = 2000;
            serverChannel.bind(new InetSocketAddress(port));

            System.out.println("Chat Server started on port " + port);

            SocketChannel client = serverChannel.accept();
            System.out.println("Connected to client: " + client.getRemoteAddress());

            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                // Read message from client
                buffer.clear();
                int bytesRead = client.read(buffer);
                if (bytesRead == -1) break;

                buffer.flip();
                String clientMsg = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("Client: " + clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                // Send response to client
                System.out.print("Server: ");
                String serverMsg = scanner.nextLine();
                buffer.clear();
                buffer.put(serverMsg.getBytes(StandardCharsets.UTF_8));
                buffer.flip();
                client.write(buffer);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server shutting down.");
                    break;
                }
            }

            client.close();
            serverChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
