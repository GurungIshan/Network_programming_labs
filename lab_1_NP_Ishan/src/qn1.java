//1. WAP to find the address of fohss.tu.edu.np (Ishan Gurung, Roll No - 9)

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn1 {
    public static void main(String[] args) {
        String host = "fohss.tu.edu.np";
        InetAddress addr = null;
        try {
           addr=  InetAddress.getByName(host);
            System.out.println("Host name is "+ addr.getHostName());
//            System.out.println("Host address is "+InetAddress.getByName("kathford.edu.np").getCanonicalHostName());
        }catch (UnknownHostException e){
            System.out.println("Host not found"+host);
            System.exit(1);
        }
        }
}
