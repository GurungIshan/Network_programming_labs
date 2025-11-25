package lab_4_Ishan;

import javax.naming.MalformedLinkException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// WAP to read the security permissions of server addresses [https://kathford.edu.np/contact-us/ and https://kathford.edu.np].
public class SecurityPermission {
    public static void main(String[] args) {
        String urlStr1 = "https://kathford.edu.np/contact-us/ ";
        String urlStr2 = "https://kathford.edu.np";
        try {
        URL url1 = new URL(urlStr1);
        URL url2 = new URL(urlStr2);
            System.out.println("Security permission for" +urlStr1+":"+ url1.openConnection().getPermission());
            System.out.println("Security permission for " +urlStr2+":"+url2.openConnection().getPermission());
        }catch (MalformedURLException e){
            System.out.println("Malformed link exception");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }
    }
}
