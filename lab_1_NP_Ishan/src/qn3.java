// 3. WAP to find the name and IP address of local machine.

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn3 {
    public static void main(String[] args) {
        try{
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("Local host name = "+ip.getHostName());
        System.out.println("Local host address = " +ip.getHostAddress());
        }catch (UnknownHostException e){
            System.out.println("Unable to find local host");
            System.exit(1);
        }
    }
}
