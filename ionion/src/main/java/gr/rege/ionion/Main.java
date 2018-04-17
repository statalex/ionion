package gr.rege.ionion;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.helper.PleskStatus;
import gr.rege.ionion.unit.ByteQty;
import gr.rege.ionion.unit.ThresholdLevel;

public class Main 
{
	static Logger log = LogManager.getLogger( Main.class);
	

	public static void main(String[] args) 
	{
//		PleskStatus.statusError( "Invalid configuration");
//		ByteQty usage = new ByteQty(120);
//		ByteQty total = new ByteQty(200);
		
//		float p = ((float )usage.toBytes() / (float )total.toBytes()) * 100;
//		System.out.println( p);
//		System.exit(0);
		log.error( "Started");

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
			PleskStatus.applicationError( "Unknow Error");
		}
	}


	static void test( String str) 
	{
	}

}
