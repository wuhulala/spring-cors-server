package clients;


import org.junit.Test;
import services.*;

/**
 * @author xueaohui
 */
public class Main {
    public static void main(String[] args) {
        MobileCodeWS service = new MobileCodeWS();
        MobileCodeWSSoap port=service.getMobileCodeWSSoap();
        String result = port.getMobileCodeInfo("15939319885", null);
        System.out.println(result);
    }

    @Test
    public void testQQOnline(){
        QqOnlineWebService service = new QqOnlineWebService();
        QqOnlineWebServiceSoap port = service.getQqOnlineWebServiceSoap();
        String result = port.qqCheckOnline("370031044");
        System.out.println(result);
    }
}
