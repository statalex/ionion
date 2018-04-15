package gr.rege.ionion.unit;

public enum ThresholdLevel 
{
	NORMAL(0), WARNING(1), CRITICAL(2), UNKNOWN(3);
	
	int value;
	
	ThresholdLevel( int theValue)
	{
		this.value = theValue;
	}

	public int getStatusCode() { return value; }
	
}
