package gr.rege.ionion.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByteQty
{
	static Logger log = LogManager.getLogger( ByteQty.class);

	private int quantity;
	private ByteFactor factor = ByteFactor.single;
	
	public ByteQty( String str) 
	{
		if( str == null || str.trim().length() == 0)
			str = "0";
		Matcher matcher = Pattern.compile("[0-9]+").matcher( str);
        if( matcher.find())
        {
        	quantity = new Integer(matcher.group());
    		matcher = Pattern.compile("[KMG%]").matcher( str);
            if( matcher.find())
            {
            	factor=ByteFactor.parse( str.substring(matcher.start(), matcher.end()) );
            } else
            	factor=ByteFactor.single;
        }
	}

	public ByteQty( int theQty) 
	{
		this( theQty, ByteFactor.single);
	}

	public ByteQty( int theQty, ByteFactor theFactor) 
	{
		this.quantity = theQty;
		this.factor = theFactor;
	}

	
	
	public int toBytes()
	{
		return quantity * factor.getFactor();
	}
	
	public String toString()
	{
		return quantity+factor.getSymbol();
	}
	
	public ByteQty convertTo( ByteFactor theFactor)
	{
		int newQty = toBytes() / theFactor.getFactor();
		return new ByteQty(newQty, theFactor) ;
	}
	
	public int compareTo( ByteQty other) 
	{
		int thisBytes = this.toBytes();
		int theBytes = other.toBytes();
		if( thisBytes<theBytes) return -1;
		if( thisBytes>theBytes) return 1;
		return 0;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ByteFactor getFactor() {
		return factor;
	}

	public void setFactor(ByteFactor factor) {
		this.factor = factor;
	}
	
	
}
