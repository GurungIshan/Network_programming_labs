package  lab_7_Ishan;

import java.io.*;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSLServer {

    private static final int PORT = 8888;
    private static final String KEYSTORE_PATH = "server.keystore";
    private static final String KEYSTORE_PASSWORD = "ishangrg";

    public static void main(String[] args) {
        try {
            char[] keystorePassword = KEYSTORE_PASSWORD.toCharArray();

            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

            InputStream fis = SSLServer.class
                    .getClassLoader()
                    .getResourceAsStream("server.keystore");

            if (fis == null) {
                throw new RuntimeException("server.keystore not found");
            }

            keystore.load(fis, keystorePassword);

            KeyManagerFactory kmf =
                    KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keystore, keystorePassword);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket =
                    (SSLServerSocket) factory.createServerSocket(PORT);

            System.out.println("SSL Server started on port " + PORT);

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                handleClientRequest(socket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(SSLSocket clientSocket) {
        try {
            // Read client request
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();

            System.out.println("Received request: " + request);

            // Process the request
            String response = "Hello from server!";

            // Send response to client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(response);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
