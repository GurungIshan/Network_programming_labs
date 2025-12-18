package Lab_5_Ishan;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

// 1. WAP to read content from server tu.edu.np at port 80 using socket.

public class SocketRead {
    public static void main(String[] args) {

        // Create socket
        // set timeout
        // open output stream
        // open input streaM
        // writer write
        // flush writer
        // read response from inputStream
        // display response
        // close socket
        String host = "time.nist.gov";
        int port = 13;
        try{
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(10000);
            InputStream inputStream = socket.getInputStream();

            // display socket information
            System.out.println("Server address : "+socket.getInetAddress());
            System.out.println("Server port : "+socket.getPort());
            System.out.println("Local address : "+socket.getLocalSocketAddress());
            System.out.println("Local port : "+socket.getLocalPort());

            InputStreamReader reader = new InputStreamReader(inputStream, "ASCII");
            StringBuilder content = new StringBuilder();
            for (int c; (c = reader.read())!=-1;){
                content.append((char)c);
            }
            System.out.println("server content: "+content);
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
