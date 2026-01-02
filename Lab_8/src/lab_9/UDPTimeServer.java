package lab_9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UDPTimeServer {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(2013);
            // recieve  datagram request
            System.out.println("sever running at " + socket.getLocalPort());
            while (true) {

                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);

                System.out.println("Got request from client  : " + request.getAddress() + "; " + request.getPort());

                // prepare date
                Date date = new Date();
                byte[] content = date.toString().getBytes("US-ASCII");

                // make datagram response
                DatagramPacket reponse = new DatagramPacket(content, content.length, request.getAddress(), request.getPort());
                socket.send(reponse);


            }


        } catch (SocketException e) {
            e.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}