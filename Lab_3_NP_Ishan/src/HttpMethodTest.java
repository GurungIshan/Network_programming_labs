// Write a program to find out which methods does a url support.[use HTTPURLConnection and HTTP Options method]

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpMethodTest {
    public static void main(String[] args) {
        String urlString = "http://www.tu.edu.np";
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("OPTIONS");
            urlConnection.connect();
            String methods = urlConnection.getHeaderField("Allow");
            System.out.println("the following methods are supported in this url : " + methods);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
