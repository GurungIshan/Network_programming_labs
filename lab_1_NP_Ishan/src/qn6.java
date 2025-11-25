//  6. WAP to check whether the addresses tu.edu.np and fohss.tu.edu.np are same.

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn6 {
    public static void main(String[] args) {
        try {

        InetAddress address1 = InetAddress.getByName("tu.edu.np");
        InetAddress address2 = InetAddress.getByName("fohss.tu.edu.np");

        System.out.println(address1.getHostAddress());
        System.out.println(address2.getHostAddress());

        if(address1.equals(address2)){
            System.out.println("Both addresses are equal");
        }
        else {
            System.out.println("Both addresses are not equal");
        }
        }catch (UnknownHostException e){
            System.out.println("Unknown host exception");
            System.exit(1);
        }
    }
}
