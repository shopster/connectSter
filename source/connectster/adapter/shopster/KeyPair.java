package connectster.adapter.shopster;

public class KeyPair
{
    private String consumerKey;
    private String consumerSecret;

    public KeyPair( String key, String secret )
    {
        this.consumerKey = key;
        this.consumerSecret = secret;
    }

    public String getConsumerKey()
    {
        return consumerKey;
    }

    public void setConsumerKey( String consumerKey )
    {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    public void setConsumerSecret( String consumerSecret )
    {
        this.consumerSecret = consumerSecret;
    }
}
