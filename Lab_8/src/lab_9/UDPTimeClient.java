package lab_9;

import java.io.IOException;
import java.net.*;

public class UDPTimeClient {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(0);
            System.out.println("The client is running at:"+socket.getLocalPort());
            InetAddress server = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, server, 2013);
            socket.send(request);

            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.receive(response);

            String content = new String(response.getData(), "US-ASCII");
            System.out.println("Received from server:" +content);

            socket.close();
        }catch (SocketException e){
            e.printStackTrace();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}




