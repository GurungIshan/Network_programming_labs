package lab_4_Ishan;

// WAP to display all the header fields and values from a webpage [kathford.edu.np] response.

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class headerFields {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://sajabazaar.com");
            URLConnection con = url.openConnection();
            // Method 1
            // Map<String,List<String>> contents = con.getHeaderFields();
            //for(String key : content.keySet()){
            // System.out.println(key + "=" +con.getHeaderFieldkey());
            // }
            // System.out.println("header completed");
            // Method 2
            for (int i =0;  ; i++){
                String value = con.getHeaderField(i);
                if(value == null) break;
                System.out.println(con.getHeaderField(i)+"=" +value);
            }
            }catch(MalformedURLException e){
                System.out.println("MalformedURLException");
        }catch (IOException e){
            System.out.println("IOException");
        }
    }
}
