// Write a program that checks the protocols a virtual machine support [ex: http, https, ftp, telnet, mailto, gopher]

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class qn2 {
    public static void main(String[] args) {
        String[] protocols = {"http", "https", "ftp", "telnet", "mailto", "gopher"};

        for (String protocol : protocols) {
            try {
                // Try to create a URL with the given protocol
                URL url = new URL(protocol + "://example.com");
                URLConnection connection = url.openConnection();
                System.out.println(protocol + " is supported.");
            } catch (MalformedURLException e) {
                System.out.println(protocol + " is not supported (Malformed URL).");
            } catch (Exception e) {
                // If another kind of exception occurs, protocol might still be supported
                System.out.println(protocol + " is supported (connection may fail).");
            }
        }
    }
}
