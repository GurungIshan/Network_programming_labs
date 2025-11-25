package lab_4_Ishan;

// WAP to guess the MIME content type of a webpage, a PDF and a PNG files.

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MIME {
    public static void main(String[] args) {
        String urlPage = "https://upcodenepal.com/";
        String urlPNG = "https://upcodenepal.com/assets/img/upcode/upcode_default.png";
        String URLCSS = "https://upcodenepal.com/styles.3c8610d9084acd91.css";
        String urlgif = "https://upcodenepal.com/assets/lib/lightbox/images/loading.gif";
        String fileName = "file:///I:/ishan.pdf";

        try{
            URL url1 = new URL(urlPage);
            URL url2= new URL(urlPNG);
            URL url3 = new URL(URLCSS);
            URL url4 = new URL(urlgif);
            URL url5 = new URL(fileName);

            URLConnection con1 =  url1.openConnection();
            URLConnection con2 =  url2.openConnection();
            URLConnection con3 =  url3.openConnection();
            URLConnection con4 =  url4.openConnection();

            System.out.println("The MIME type of web is "+con1.getContentType());
            System.out.println("The MIME type of PNG is "+con2.getContentType());
            System.out.println("The MIME type of CSS is "+con3.getContentType());
            System.out.println("The MIME type of JPG is "+con4.getContentType());
            System.out.println("The MIME type of my file is "+URLConnection.guessContentTypeFromName(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
