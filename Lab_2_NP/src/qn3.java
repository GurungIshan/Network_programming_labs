// Write a program to download a web page of a given web address [ex: www.kathford.edu.np]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class qn3 {
    public static void main(String[] args) {
        String website = "https://www.kathford.edu.np";
        try {
            URL url = new URL(website);

            // Open a stream to read the web page content
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            System.out.println("Content of the web page:\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to download the web page.");
            e.printStackTrace();
        }
    }
}
