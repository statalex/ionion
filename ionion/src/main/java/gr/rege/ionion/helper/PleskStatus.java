package gr.rege.ionion.helper;

import gr.rege.ionion.unit.ByteQty;
import gr.rege.ionion.unit.Threshold;
import gr.rege.ionion.unit.ThresholdLevel;

public class PleskStatus 
{

	public static void applicationError( String msg)
	{
		System.out.println("Application Error - "+msg);
		System.exit( ThresholdLevel.UNKNOWN.getStatusCode());
	}

	public static void usageStatus( Threshold threshold, int used, int total, String msg)
	{
		ByteQty usedQty = new ByteQty(used);
		ByteQty totalQty = new ByteQty( total);
		ThresholdLevel level = threshold.checkLevel( usedQty, totalQty);
		msg = msg+String.format("%s of %s", usedQty.toString(), totalQty.toString());
		System.out.println(msg);
		System.exit( level.getStatusCode());
	}
}
