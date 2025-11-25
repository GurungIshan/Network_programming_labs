//  2. WAP to check whether the address is IPv4 or IPv6. (Ishan Roll no-9)

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn2 {
    public static void main(String[] args) {
        String host = "www.instagram.com";
        InetAddress inet = null;
        try{
            inet = InetAddress.getByName(host);
            String hostaddr = inet.getHostAddress();
            byte[] b = inet.getAddress();
            if(b.length==4){
                System.out.println("Host address " +hostaddr+" is IPv4 address");
            } else if (b.length==16) {
                System.out.println("Host address " +hostaddr+" is IPv6 address");
            }
        }catch(UnknownHostException e){
            System.out.println("Host not found"+host);
            System.exit(1);
        }
    }

}
