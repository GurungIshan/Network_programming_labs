// 8. WAP to process the server log files.Store the given content
// in a file and process it for question (Ishan Gurung, Roll No- 09)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qn8 {
    public static void main(String[] args) {
        String logFile = "src/server_log.log"; // path to your log file

        // Regex to capture IP, resource requested, and HTTP response code
        String logPattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+) - - \\[.*?\\] \"[A-Z]+ (.*?) HTTP/.*?\" (\\d{3})";

        Pattern pattern = Pattern.compile(logPattern);

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            System.out.println("IP Address\t\tResource Requested\tHTTP Response");
            System.out.println("-----------------------------------------------------------");

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String ip = matcher.group(1);
                    String resource = matcher.group(2);
                    String response = matcher.group(3);

                    System.out.println(ip + "\t" + resource + "\t" + response);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the log file: " + e.getMessage());
        }
    }
}
