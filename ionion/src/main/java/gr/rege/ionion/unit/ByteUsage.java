package gr.rege.ionion.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteUsage 
{
	private int size;
	private ByteUnit unit = ByteUnit.Byte;
	
	public ByteUsage( String str) 
	{
		Matcher matcher = Pattern.compile("[0-9]+").matcher( str);
        if( matcher.find())
        {
        	size = new Integer(matcher.group());
    		matcher = Pattern.compile("[KMG%]").matcher( str);
            if( matcher.find())
            {
            	unit=ByteUnit.parse( str.substring(matcher.start(), matcher.end()) );
            } else
            	unit=ByteUnit.Byte;
        }
    	System.out.format( "%d%s\n", size, unit.getSymbol() );
	}
}
