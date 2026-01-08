package lab_9;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class UDPChatClient {

    public static void main(String[] args) {

        try {
            DatagramChannel channel = DatagramChannel.open();
            InetSocketAddress serverAddress =
                    new InetSocketAddress("localhost", 2013);

            Scanner sc = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            System.out.println("UDP Chat Client started");

            while (true) {
                // Send message to server
                System.out.print("Client: ");
                String msg = sc.nextLine();

                buffer.clear();
                buffer.put(msg.getBytes());
                buffer.flip();
                channel.send(buffer, serverAddress);

                // Receive reply from server
                buffer.clear();
                channel.receive(buffer);
                buffer.flip();

                String serverMsg = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Server: " + serverMsg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
