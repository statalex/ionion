package gr.rege.ionion;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.info.DomainInfo;
import gr.rege.ionion.info.SubscriptionInfo;

public class DomainChecker 
{
	private PleskEnv env;
	
	public DomainChecker( PleskEnv theEnv) 
	{
		this.env = theEnv;
	}
	
	public void check()
	{
		try 
		{
			DomainInfo domain = new DomainInfo().parse(env.client, "a-sakkali.gr");
			SubscriptionInfo subscription = new SubscriptionInfo().parse(env.client, "a-sakkali.gr");
			if( domain.realSize < subscription.diskSpace)
				System.out.println("OK");
		} catch (Exception e) 
		{
		}
		
//		new SubscriptionInfo().parse(client, "a-sakkali.gr");
		
	}
}
