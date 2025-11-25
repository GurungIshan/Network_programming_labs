// Write a program to demonstrate the x-www-form-urlencoded strings.

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class qn6 {
    public static void main(String[] args) {
        try {
            String name = "Ishan Gurung";
            String email = "ishan@kathford.edu.np";
            String message = "Hello! How are you?";

            // Encode the data to x-www-form-urlencoded format
            String encodedData = "name=" + URLEncoder.encode(name, "UTF-8") +
                    "&email=" + URLEncoder.encode(email, "UTF-8") +
                    "&message=" + URLEncoder.encode(message, "UTF-8");

            // Display encoded form data
            System.out.println("Encoded (x-www-form-urlencoded) data:");
            System.out.println(encodedData);

            // Decode it back to original form
            String decodedData = URLDecoder.decode(encodedData, "UTF-8");
            System.out.println("\nDecoded back to original data:");
            System.out.println(decodedData);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: Unsupported encoding format." + e.getMessage());
        }
    }
}



