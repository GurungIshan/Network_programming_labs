// Write a program that splits the parts of a URL
// [ex: https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-]

import java.net.MalformedURLException;
import java.net.URL;

public class qn1 {
    public static void main(String[] args) {
        try {
        String urlStr = " https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-";
            URL url = new URL(urlStr);
            System.out.println("Protocol: "+url.getProtocol());
            System.out.println("Hostname: "+url.getHost());
            System.out.println("Port: "+url.getPort());
            System.out.println("Path : "+url.getPath());
            System.out.println("Filename: "+url.getFile());
            System.out.println("Query: "+url.getQuery());
            System.out.println("Fragment Id: "+url.getRef());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
