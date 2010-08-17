
package shopster.apis.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Main", targetNamespace = "urn:shopster:apis:main", wsdlLocation = "file:/C:/zip/wsdl.xml")
public class Main
    extends Service
{

    private final static URL MAIN_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(shopster.apis.main.Main.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = shopster.apis.main.Main.class.getResource(".");
            url = new URL(baseUrl, "file:/C:/zip/wsdl.xml");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/zip/wsdl.xml', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MAIN_WSDL_LOCATION = url;
    }

    public Main(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Main() {
        super(MAIN_WSDL_LOCATION, new QName("urn:shopster:apis:main", "Main"));
    }

    /**
     * 
     * @return
     *     returns IMain
     */
    @WebEndpoint(name = "MainBinding_IMain")
    public IMain getMainBindingIMain() {
        return super.getPort(new QName("urn:shopster:apis:main", "MainBinding_IMain"), IMain.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMain
     */
    @WebEndpoint(name = "MainBinding_IMain")
    public IMain getMainBindingIMain(WebServiceFeature... features) {
        return super.getPort(new QName("urn:shopster:apis:main", "MainBinding_IMain"), IMain.class, features);
    }

}