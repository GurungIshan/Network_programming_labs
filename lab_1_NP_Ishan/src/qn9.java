// 9. WAP to check if a host is reachable or not. (Ishan Gurung, Roll no - 09)

import java.net.InetAddress;

public class qn9 {
    public static void main(String[] args) {
        String host = "www.google.com";

        try {
            InetAddress inet = InetAddress.getByName(host);
            System.out.println("Checking reachability of " + host + " ...");

            if (inet.isReachable(5000)) {
                System.out.println(host + " is reachable.");
            } else {
                System.out.println(host + " is not reachable.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
