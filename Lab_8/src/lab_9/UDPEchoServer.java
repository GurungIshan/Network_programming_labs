package lab_9;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(2013);
            System.out.println("UDP Echo Server started on port 2013");

            byte[] buffer = new byte[1024];

            while (true) {
                // Receive request
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String message = new String(request.getData(), 0, request.getLength(), "US-ASCII"
                );

                System.out.println("Received from client: " + message);

                // Echo back same message
                DatagramPacket response = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort()
                );

                socket.send(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
