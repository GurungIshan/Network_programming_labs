import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class qn5 {
    public static void main(String[] args) {
        String fileURL = "https://raw.githubusercontent.com/github/explore/main/topics/java/java.png";
        String savePath = "java-logo.png";

        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

            System.out.println("Download complete! File saved as: " + savePath);

        } catch (IOException e) {
            System.out.println("Error downloading the object: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
