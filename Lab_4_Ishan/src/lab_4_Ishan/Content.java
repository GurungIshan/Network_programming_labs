package lab_4_Ishan;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
public class Content {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://rabinpyakurel.com.np");
            URLConnection con = url.openConnection();
            System.out.println(con.getContentType());
            System.out.println(con.getContentLength());
            System.out.println(new Date(con.getLastModified()));
            System.out.println(new Date(con.getDate()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}