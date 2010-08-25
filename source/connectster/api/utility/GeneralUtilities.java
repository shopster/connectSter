package connectster.api.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneralUtilities
{
    public static String convertStackTraceToString( Throwable x )
    {
        StringWriter sw = new StringWriter();
        x.printStackTrace( new PrintWriter( sw ) );
        return sw.toString();
    }

    public static String md5( String input )
    {
        byte[ ] defaultBytes = input.getBytes();
        try
        {
            MessageDigest algorithm = MessageDigest.getInstance( "MD5" );
            algorithm.reset();
            algorithm.update( defaultBytes );
            byte messageDigest[ ] = algorithm.digest();

            StringBuffer hexString = new StringBuffer();
            for( byte aMessageDigest : messageDigest )
            {
                String hex = Integer.toHexString( 0xFF & aMessageDigest );
                if( hex.length() == 1 )
                {
                    hexString.append( '0' );
                }

                hexString.append( hex );
            }

            return hexString.toString( );
        }
        catch( NoSuchAlgorithmException x )
        {
            throw new RuntimeException( x );
        }
    }

    public static String urlEncode( String input )
    {
        try
        {
            return URLEncoder.encode( input, "UTF-8" );
        }
        catch( UnsupportedEncodingException x )
        {
            return input;
        }
    }
}
