package gr.rege.ionion.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByteQty
{
	static Logger log = LogManager.getLogger( ByteQty.class);

	private long quantity;
	private ByteFactor factor = ByteFactor.single;
	
	public ByteQty( String str) 
	{
		if( str == null || str.trim().length() == 0)
			str = "0";
		Matcher matcher = Pattern.compile("[0-9]+").matcher( str);
        if( matcher.find())
        {
        	quantity = new Long(matcher.group());
    		matcher = Pattern.compile("[KMG%]").matcher( str);
            if( matcher.find())
            {
            	factor=ByteFactor.parse( str.substring(matcher.start(), matcher.end()) );
            } else
            	factor=ByteFactor.single;
        }
	}

	public ByteQty( long theQty) 
	{
		this( theQty, ByteFactor.single);
	}

	public ByteQty( long theQty, ByteFactor theFactor) 
	{
		this.quantity = theQty;
		this.factor = theFactor;
	}

	
	
	public long toBytes()
	{
		return quantity * factor.getFactor();
	}
	
	public String toString()
	{
		return quantity+factor.getSymbol();
	}
	
	public ByteQty convertTo( ByteFactor theFactor)
	{
		long newQty = toBytes() / theFactor.getFactor();
		return new ByteQty(newQty, theFactor) ;
	}
	
	public int compareTo( ByteQty other) 
	{
		long thisBytes = this.toBytes();
		long theBytes = other.toBytes();
		if( thisBytes<theBytes) return -1;
		if( thisBytes>theBytes) return 1;
		return 0;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity( long quantity) {
		this.quantity = quantity;
	}

	public ByteFactor getFactor() {
		return factor;
	}

	public void setFactor(ByteFactor factor) {
		this.factor = factor;
	}
	
	
}
