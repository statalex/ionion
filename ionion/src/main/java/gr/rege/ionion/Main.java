package gr.rege.ionion;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import gr.rege.ionion.helper.ByteUsage;
import gr.rege.ionion.helper.PleskEnv;

public class Main 
{
//	static Logger log = LogManager.getLogger( Main.class);
	

	public static void main(String[] args) throws Exception 
	{
		new ByteUsage("128");
		new ByteUsage("128K");
		new ByteUsage("128M");
		new ByteUsage("128G");
		new ByteUsage("128%");
		System.exit(0);
		System.out.println("Started");

		PleskEnv env = PleskEnv.get(args);
		switch( env.mode)
		{
			case DOMAIN :
				new DomainChecker(env).check();
				break;
			case MBOX :
				break;
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
