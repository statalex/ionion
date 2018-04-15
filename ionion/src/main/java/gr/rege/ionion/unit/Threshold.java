package gr.rege.ionion.unit;

public class Threshold 
{
	private ByteQty warning;
	private ByteQty critical;
	
	public Threshold(ByteQty theWarning, ByteQty theCritical) 
	{
		this.warning = theWarning;
		this.critical = theCritical;
	}
	
	public ByteQty getWarning() {	return warning;	}

	public void setWarning(ByteQty warning) {	this.warning = warning;	}
	public ByteQty getCritical() {	return critical;	}
	public void setCritical(ByteQty critical) {		this.critical = critical;	}

	
	public ThresholdLevel checkLevel( ByteQty qty)
	{
		return checkLevel(qty, null);
	}

	public ThresholdLevel checkLevel( ByteQty current, ByteQty total)
	{
		try 
		{
			if( exceeds( critical, current, total))
				return ThresholdLevel.CRITICAL;
			if( exceeds( warning, current, total))
				return ThresholdLevel.WARNING;
		} catch (Throwable e) 
		{
			return ThresholdLevel.UNKNOWN;
		}
		return ThresholdLevel.NORMAL;
	}

	private static boolean exceeds( ByteQty level, ByteQty usage, ByteQty total)
	{
		if( level == null || usage == null)
			throw new Error("Not null allowed");
		if( level.getFactor().isPercentage())
		{
			if( total == null)
				throw new Error("Percentage needs two factors");
			float p = ((float )usage.toBytes() / (float )total.toBytes()) * 100;
			return ( p > level.toBytes()) ?true :false;
		} else
			return usage.compareTo(level)>=0;
	}

}
