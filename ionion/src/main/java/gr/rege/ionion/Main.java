package gr.rege.ionion;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.helper.PleskStatus;

public class Main 
{
	static Logger log = LogManager.getLogger( Main.class);
	

	public static void main(String[] args) 
	{
		System.out.println( "#1");
//		log.trace( "Started");

		try 
		{
			PleskEnv env = PleskEnv.get(args);
			switch( env.mode)
			{
				case DOMAIN :
					new DiskUsageChecker(env).checkDomain();
					break;
				case MBOX :
					break;
				case LOGS :
					new DiskUsageChecker(env).checkLog();
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
