package gr.rege.ionion;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.helper.PleskStatus;
import gr.rege.ionion.info.DomainInfo;
import gr.rege.ionion.info.SubscriptionInfo;
import gr.rege.ionion.unit.ByteQty;
import gr.rege.ionion.unit.ThresholdLevel;

public class DomainChecker 
{
	private PleskEnv env;
	private DomainInfo domain;
	private SubscriptionInfo subscription;
	
	public DomainChecker( PleskEnv theEnv) 
	{
		this.env = theEnv;
	}
	
	public void check()
	{
		try 
		{
			domain = new DomainInfo().parse(env.client, env.domain);
			subscription = new SubscriptionInfo().parse(env.client, env.domain);
//			ByteQty used = new ByteQty(domain.realSize);
//			ByteQty total = new ByteQty( subscription.diskSpace);
//			ThresholdLevel level = env.threshold.checkLevel( used, total);
//			String msg = String.format("%s of %s", used.toString(), total.toString());
			PleskStatus.usageStatus( env.threshold, domain.realSize, subscription.diskSpace, "");
		} catch (Exception e) 
		{
			PleskStatus.applicationError(e.getMessage());
		}
	}
	
	public void status( ThresholdLevel level, String msg)
	{
		String levelName = level.name()+" - ";
/*
		switch( level)
		{
			case NORMAL :
				levelName = "OK - ";
				break;
			case WARNING :
				levelName = "WARNING - ";
				break;
			case CRITICAL :
				System.out.println();
				break;
			case UNKNOWN :
			default :
				System.out.println();
				break;
		}
*/		
		System.out.println( levelName+msg);
		System.exit( level.getStatusCode());
	}
	
	public void check_()
	{
		
	}
}
