// 7. WAP to list the names and display name of all network adapters in the machine. (Ishan Gurung)

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class qn7 {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            if (interfaces == null) {
                System.out.println("No network interfaces found.");
                return;
            }

            // Loop through each interface and display name + display name
            while (interfaces.hasMoreElements()) {
                NetworkInterface netIf = interfaces.nextElement();
                System.out.println("Name: " + netIf.getName());
                System.out.println("Display Name: " + netIf.getDisplayName());
                System.out.println("----------------------------------");
            }
        } catch (SocketException e) {
            System.out.println("Error retrieving network interfaces: " + e.getMessage());
        }

    }
}
