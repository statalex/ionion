package gr.rege.ionion.helper;

public class PleskError extends RuntimeException 
{
	private static final long serialVersionUID = 2624546277577509197L;

	public PleskError() 
	{
	}

	public PleskError(String message) 
	{
		super(message);
	}

	public PleskError(Throwable cause) 
	{
		super(cause);
	}

	public PleskError(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public PleskError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
