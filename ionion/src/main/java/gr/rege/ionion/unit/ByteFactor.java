package gr.rege.ionion.unit;

public class ByteFactor 
{
	
	private String symbol;
	private int factor;
	private boolean isPercentage;
	


	private ByteFactor( int theFactor, String theSymbol, boolean thePercentage) 
	{
		this.symbol = theSymbol;
		this.factor = theFactor;
		this.isPercentage = thePercentage;
	}
	
	public String getSymbol()
	{
		return this.symbol;
	}
	
	public int getFactor()
	{
		return this.factor;
	}
	
	
	public boolean isPercentage() 
	{
		return isPercentage;
	}

	public static ByteFactor parse( String str)
	{
		if( giga.getSymbol().compareToIgnoreCase(str)==0)
			return giga;
		if( mega.getSymbol().compareToIgnoreCase(str)==0)
			return mega;
		if( kilo.getSymbol().compareToIgnoreCase(str)==0)
			return kilo;
		if( percent.getSymbol().compareToIgnoreCase(str)==0)
			return percent;
		return single;
	}

	public static ByteFactor single = new ByteFactor(1, "", false);
	public static ByteFactor percent = new ByteFactor(1, "", true);
	public static ByteFactor kilo = new ByteFactor(1024, "K", false);
	public static ByteFactor mega = new ByteFactor(1024*1024, "M", false);
	public static ByteFactor giga = new ByteFactor(1024*1024*1024, "G", false);
}
