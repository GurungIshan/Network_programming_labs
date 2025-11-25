// Write a program that communicate with Server-Side Programs Through GET.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class qn7 {
    public static void main(String[] args) {
        try {
            // Base URL of the server-side program (for example, a PHP or JSP endpoint)
            String baseURL = "https://httpbin.org/get"; // public test server

            // Form data to send
            String name = "Ishan Gurung";
            String college = "Kathford International College";

            // Encode the parameters to x-www-form-urlencoded format
            String query = String.format("name=%s&college=%s",
                    URLEncoder.encode(name, "UTF-8"),
                    URLEncoder.encode(college, "UTF-8"));

            // Construct full URL (GET request)
            String fullURL = baseURL + "?" + query;

            // Create a URL object
            URL url = new URL(fullURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Read the server response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Display the response
            System.out.println("Response from server:");
            System.out.println(response.toString());

        } catch (IOException e) {
            System.out.println("Error: Unable to send GET request.");
            e.printStackTrace();
        }
    }
}
