
// 5. WAP to find all the addresses of dns.google.com

import java.net.InetAddress;
import java.net.UnknownHostException;

public class qn5 {
    public static void main(String[] args) {
        String host = "dns.google.com";
        InetAddress[] addr = null;
        try {
            addr=  InetAddress.getAllByName(host);
            for(InetAddress inetAddress : addr){
                String ipaddr = inetAddress.getHostAddress();
                byte[] bytes = inetAddress.getAddress();
                if(bytes.length == 4){
                    System.out.println("Ipv4 address: "+ipaddr);
                } else if (bytes.length==16) {
                    System.out.println("IPv6 address: "+ipaddr);
                }
            }
        }catch (UnknownHostException e){
            System.out.println("Host not found"+host);
            System.exit(1);
        }
    }
}
