package lab_4_Ishan;

import java.net.URLConnection;

public class MIME {

    public static void main(String[] args) {
        // HTML file
        String html = "index.html";
        String htmlType = URLConnection.guessContentTypeFromName(html);

        // Image file
        String image = "picture.gif";
        String imageType = URLConnection.guessContentTypeFromName(image);

        // Text file
        String file = "notes.txt";
        String fileType = URLConnection.guessContentTypeFromName(file);

        // Print results
        System.out.println("File Name : " + html);
        System.out.println("MIME Type : " + htmlType);
        System.out.println();

        System.out.println("File Name : " + image);
        System.out.println("MIME Type : " + imageType);
        System.out.println();

        System.out.println("File Name : " + file);
        System.out.println("MIME Type : " + fileType);
    }
}
