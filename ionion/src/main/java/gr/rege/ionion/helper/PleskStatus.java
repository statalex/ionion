package gr.rege.ionion.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.unit.ByteQty;
import gr.rege.ionion.unit.Threshold;
import gr.rege.ionion.unit.ThresholdLevel;

public class PleskStatus 
{
	static Logger log = LogManager.getLogger( PleskStatus.class);

	public static void applicationError( String msg)
	{
		System.out.println("Application Error - "+msg);
		System.exit( ThresholdLevel.UNKNOWN.getStatusCode());
	}

	public static void usageStatus( Threshold threshold, long used, long total, String msg)
	{
		log.error(String.format("Comparing %d %d", used, total));
		ByteQty usedQty = new ByteQty(used);
		ByteQty totalQty = new ByteQty( total);
		ThresholdLevel level = threshold.checkLevel( usedQty, totalQty);
		String levelName = level.name();
		msg = msg+String.format("%s - %s of %s", levelName, usedQty.toHuman(), totalQty.toHuman());
		System.out.println(msg);
		System.exit( level.getStatusCode());
	}
}
