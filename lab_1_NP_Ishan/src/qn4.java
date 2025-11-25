// 4. WAP to find the canonical and host name of a given IP.

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn4 {
    public static void main(String[] args) {
        String host = "fohss.tu.edu.np";
        InetAddress addr = null;
        try {
            addr=  InetAddress.getByName(host);
            System.out.println("Host address is "+InetAddress.getByName("kathford.edu.np").getCanonicalHostName());
        }catch (UnknownHostException e){
            System.out.println("Host not found"+host);
            System.exit(1);
        }
    }
}
