package lab_9;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(0);
            System.out.println("Client running on port " + socket.getLocalPort());

            InetAddress server = InetAddress.getByName("localhost");

            String message = "Hello UDP Echo Server";
            byte[] data = message.getBytes("US-ASCII");

            // Send message
            DatagramPacket request = new DatagramPacket(data, data.length, server, 2013);
            socket.send(request);

            // Receive echo
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.receive(response);

            String echo = new String(response.getData(), 0, response.getLength(), "US-ASCII"
            );

            System.out.println("Echo from server: " + echo);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}