package lab_9;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class UDPChatServer {

    public static void main(String[] args) {

        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.bind(new InetSocketAddress(2013));

            System.out.println("UDP Chat Server started on port 2013");

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Scanner sc = new Scanner(System.in);

            InetSocketAddress clientAddress = null;

            while (true) {
                // Receive message from client
                buffer.clear();
                clientAddress = (InetSocketAddress) channel.receive(buffer);
                buffer.flip();

                String clientMsg = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Client: " + clientMsg);

                // Send reply to client
                System.out.print("Server: ");
                String serverMsg = sc.nextLine();

                buffer.clear();
                buffer.put(serverMsg.getBytes());
                buffer.flip();

                channel.send(buffer, clientAddress);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
