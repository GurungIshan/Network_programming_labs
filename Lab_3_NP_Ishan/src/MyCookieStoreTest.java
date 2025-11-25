import java.net.HttpCookie;
import java.net.URI;

public class MyCookieStoreTest {
    public static void main(String[] args) {
        MyCookieStore store = new MyCookieStore();
        try{
            URI uri1 = new URI("http://www.tu.edu.np");
            URI uri2= new URI("http://www.hello.com.np");

            HttpCookie cookie1 = new HttpCookie("session","abcd11234");
            cookie1.setDomain("www.tu.edu.np");
            HttpCookie cookie2 = new HttpCookie("user","Ishan");
            cookie2.setDomain("www.hello.com.np");

            store.add(uri1,cookie1);
            store.add(uri2, cookie2);

            System.out.println("Cookies for " +uri1.getHost()+":"+store.get(uri1));
            System.out.println("Cookies for " +uri2.getHost()+":"+store.get(uri2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
