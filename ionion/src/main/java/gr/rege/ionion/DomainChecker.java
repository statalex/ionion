package gr.rege.ionion;

import gr.rege.ionion.helper.PleskEnv;
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
			if( domain.realSize < subscription.diskSpace)
				System.out.println("OK");
		} catch (Exception e) 
		{
		}
		
//		new SubscriptionInfo().parse(client, "a-sakkali.gr");
		
	}
	
	public void status()
	{
		ThresholdLevel level = env.threshold.checkLevel(new ByteQty(domain.realSize), new ByteQty( subscription.diskSpace));
		if( domain.realSize < subscription.diskSpace)
			System.out.println("OK");
	}
	
	public void check_()
	{
		
	}
}
