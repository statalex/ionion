package gr.rege.ionion.unit;

public enum ByteUnit 
{
	Byte("", 1), KByte("K", 1024), MByte("M", 1024*1024), GByte("G", 1024*1024*1024), Percent("%", 0);
	
	private String symbol;
	private int factor;
	
	public String getSymbol() 	{ return symbol; }
	public int getFactor() 		{ return factor;	}

	private ByteUnit( String theSymbol, int theFactor) 
	{
		this.symbol = theSymbol;
		this.factor = theFactor;
	}
	
	public static ByteUnit parse( String str)
	{
		for( ByteUnit unit : ByteUnit.values())
			if( unit.symbol.compareToIgnoreCase(str)==0)
				return unit;
		return null;
	}
	
}
