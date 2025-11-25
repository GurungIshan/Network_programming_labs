// Write a program for resolving relative URI [https://kathford.edu.np/about-us/, /kathford-scholarships]

import java.net.URI;
import java.net.URISyntaxException;

public class qn4 {
    public static void main(String[] args) {
        try {
            // Base URI
            URI base = new URI("https://kathford.edu.np/about-us/");

            // Relative URI
            URI relative = new URI("/kathford-scholarships");

            // Resolve the relative URI against the base URI
            URI resolved = base.resolve(relative);

            System.out.println("Base URI     : " + base);
            System.out.println("Relative URI : " + relative);
            System.out.println("Resolved URI : " + resolved);
        } catch (URISyntaxException e) {
            System.out.println("Error: Invalid URI syntax.");
            e.printStackTrace();
        }
    }
}
