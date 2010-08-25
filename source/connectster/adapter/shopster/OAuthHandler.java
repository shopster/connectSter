package connectster.adapter.shopster;

import org.scribe.http.Request;
import org.scribe.oauth.Scribe;
import org.scribe.oauth.Token;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.*;


public class OAuthHandler
implements SOAPHandler<SOAPMessageContext>
{
    private final static String HTTP_HEADER_AUTHORIZATION = "Authorization";
    private final static String WS_VERB = "POST";

    private String endpoint, oauthUri, consumerKey, consumerSecret, accessToken, accessSecret;

    public OAuthHandler( String endpoint, String oauthUri, String consumerKey, String consumerSecret, String accessToken, String accessSecret )
    {
        this.endpoint = endpoint;
        this.oauthUri = oauthUri;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessSecret = accessSecret;
        this.accessToken = accessToken;
    }

    @Override
    public Set<QName> getHeaders()
    {
        return new TreeSet<QName>();
    }

    @Override
    public boolean handleMessage( SOAPMessageContext context )
    {
        Boolean outboundProperty = (Boolean) context.get( MessageContext.MESSAGE_OUTBOUND_PROPERTY );
        if( !outboundProperty )
        {
            return true;
        }

        Properties scribeProperties = new Properties( );
        scribeProperties.setProperty( "consumer.key", consumerKey );
        scribeProperties.setProperty( "consumer.secret", consumerSecret );
        scribeProperties.setProperty( "soapRequest.token.verb", WS_VERB );
        scribeProperties.setProperty( "soapRequest.token.url", oauthUri );
        scribeProperties.setProperty( "access.token.verb", WS_VERB );
        scribeProperties.setProperty( "access.token.url", oauthUri );
        Scribe scribe = new Scribe( scribeProperties );

        try
        {
            Request httpRequest = new Request( Request.Verb.POST, endpoint );
            scribe.signRequest( httpRequest, new Token( accessToken, accessSecret ) );
            context.put( SOAPMessageContext.HTTP_REQUEST_HEADERS, Collections.singletonMap( HTTP_HEADER_AUTHORIZATION,
                Collections.singletonList( httpRequest.getHeaders( ).get( HTTP_HEADER_AUTHORIZATION ) ) ) );
        }
        catch( Exception x )
        {
            System.err.println( x );
            return false;
        }

        return true;
    }

    @Override
    public boolean handleFault( SOAPMessageContext context )
    {
        return true;
    }

    @Override
    public void close( MessageContext context )
    {
    }
}
