package gr.rege.ionion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.helper.PleskStatus;
import gr.rege.ionion.info.DomainInfo;
import gr.rege.ionion.info.SubscriptionInfo;
import gr.rege.ionion.unit.ByteQty;
import gr.rege.ionion.unit.ThresholdLevel;

public class DiskUsageChecker 
{
	static Logger log = LogManager.getLogger( DiskUsageChecker.class);

	private PleskEnv env;
	private DomainInfo domain;
	private SubscriptionInfo subscription;
	
	public DiskUsageChecker( PleskEnv theEnv) 
	{
		this.env = theEnv;
	}
	
	public void checkDomain()
	{
		try 
		{
			domain = new DomainInfo().parse(env.client, env.domain);
			subscription = new SubscriptionInfo().parse(env.client, env.domain);
			usageStatus( domain.realSize, subscription.diskSpace, "");
		} catch (Exception e) 
		{
			PleskStatus.applicationError(e.getMessage());
		}
	}

	public void checkLog()
	{
		try 
		{
			domain = new DomainInfo().parse(env.client, env.domain);
			subscription = new SubscriptionInfo().parse(env.client, env.domain);
			usageStatus( domain.usage.logs, subscription.diskSpace, "");
		} catch (Exception e) 
		{
			PleskStatus.applicationError(e.getMessage());
		}
	}
	
	private void usageStatus( long used, long total, String msg)
	{
		log.error(String.format("Comparing %d %d", used, total));
		ByteQty usedQty = new ByteQty(used);
		ByteQty totalQty = new ByteQty( total);
		ThresholdLevel level = env.threshold.checkLevel( usedQty, totalQty);
		String levelName = level.name();
		msg = msg+String.format("%s - %s of %s", levelName, usedQty.toHuman(), totalQty.toHuman());
		System.out.println(msg);
		System.exit( level.getStatusCode());
	}
	
	
}
