package gr.rege.ionion;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.unit.ByteQty;

public class Main 
{
	static Logger log = LogManager.getLogger( Main.class);
	

	public static void main(String[] args) 
	{
		ByteQty usage = new ByteQty(120);
		ByteQty total = new ByteQty(200);
		
		float p = ((float )usage.toBytes() / (float )total.toBytes()) * 100;

		System.out.println( p);
		System.exit(0);
		System.out.println("Started");

		try 
		{
			PleskEnv env = PleskEnv.get(args);
			switch( env.mode)
			{
				case DOMAIN :
					new DomainChecker(env).check();
					break;
				case MBOX :
					break;
			}
			
		} catch (Exception e) 
		{
			System.out.println("Error");
		}
	}


	static void test( String str) 
	{

//		Pattern pattern = Pattern.compile("[0-9]+");
//		Matcher matcher = pattern.matcher( str);
		Matcher matcher = Pattern.compile("[0-9]+").matcher( str);
        if( matcher.find())
        {
        	System.out.println("Size is "+matcher.group());
    		System.out.println( matcher.start());
    		System.out.println( matcher.end());
    		matcher = Pattern.compile("[KMG%]").matcher( str);
            if( matcher.find())
            {
            	System.out.println("Unit is "+matcher.group() );
        		System.out.println( matcher.start());
        		System.out.println( matcher.end());
            }
        }
	}

}
