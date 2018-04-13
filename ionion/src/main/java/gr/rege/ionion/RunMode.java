package gr.rege.ionion;

public enum RunMode 
{

//	DOMAIN("domain"), MBOX("mbox");
	DOMAIN, MBOX;
	
	public static RunMode value( String str)
	{
		return valueOf(str.toUpperCase());
	}
	
}
