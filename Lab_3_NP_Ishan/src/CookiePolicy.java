import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CookiePolicy implements java.net.CookiePolicy {
        @Override
                public boolean shouldAccept(URI uri, HttpCookie cookie){
            if(uri.getHost().contains(".com.np")){
                System.out.println("The cookie is allowed for this domain: "+uri.getHost());
                return true;
            }
            System.out.println("The cookie is blocked for this domain"+uri.getHost());
            return false;
        }
    public static void main(String[] args) {
            CookiePolicy policy = new CookiePolicy();
            CookieManager manager = new CookieManager();
            manager.setCookiePolicy(policy);
            try{
                URI uri = new URI("http://www.tu.edu.np");
                URI uri2= new URI("https://www.hrllo.com.np");

             List<String> mycookies = new ArrayList<String>();
             mycookies.add("key = value");

             HashMap<String,List<String>> hashMap = new HashMap<String,List<String>>(){{
                 put("Set-Cookie",mycookies);
             }};
             manager.put(uri,hashMap);
             manager.put(uri2,hashMap);
         } catch (URISyntaxException e){
             System.out.println(e.getMessage());
         }catch (IOException e){
             e.printStackTrace();
         }
    }
}
