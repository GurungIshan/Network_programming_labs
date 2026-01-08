package lab_7_Ishan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static final String TRUSTSTORE_PASSWORD = "ishangrg";

    public static void main(String[] args) {
        try {
            char[] truststorePassword = TRUSTSTORE_PASSWORD.toCharArray();

            KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());

            InputStream fis = SSLClient.class
                    .getClassLoader()
                    .getResourceAsStream("client.truststore");

            if (fis == null) {
                throw new RuntimeException("client.truststore not found");
            }

            truststore.load(fis, truststorePassword);

            TrustManagerFactory tmf =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(truststore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory factory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(HOST, PORT);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello from client!");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Received response: " + reader.readLine());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
