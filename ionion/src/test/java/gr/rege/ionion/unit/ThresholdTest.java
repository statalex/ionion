package gr.rege.ionion.unit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThresholdTest 
{
	private static ByteQty warning150 = new ByteQty( 150);
	private static ByteQty critical180 = new ByteQty( 180);

	private static ByteQty qtyUnderWarning = new ByteQty( 149);
	private static ByteQty qtyEqualsWarning = new ByteQty( 150);
	private static ByteQty qtyAboveWarning = new ByteQty( 151);

	private static ByteQty qtyUnderCritical = new ByteQty( 179);
	private static ByteQty qtyEqualsCritical = new ByteQty( 180);
	private static ByteQty qtyAboveCritical = new ByteQty( 181);
	
	private static Threshold threshold = new Threshold(warning150, critical180);

	@Test public void testUnderWarning()	{ assertEquals( ThresholdLevel.NORMAL, threshold.checkLevel(qtyUnderWarning)); }
	@Test public void testEqualsWarning()	{ assertEquals( ThresholdLevel.WARNING, threshold.checkLevel(qtyEqualsWarning)); }
	@Test public void testAboveWarning()	{ assertEquals( ThresholdLevel.WARNING, threshold.checkLevel(qtyAboveWarning)); }

	@Test public void testUnderCritical()	{ assertEquals( ThresholdLevel.WARNING, threshold.checkLevel(qtyUnderCritical)); }
	@Test public void testEqualsCritical()	{ assertEquals( ThresholdLevel.CRITICAL, threshold.checkLevel(qtyEqualsCritical)); }
	@Test public void testAboveCritical()	{ assertEquals( ThresholdLevel.CRITICAL, threshold.checkLevel(qtyAboveCritical)); }
	

	@Test public void testCheckWithNull() { assertEquals( ThresholdLevel.UNKNOWN, threshold.checkLevel( null));	}
	
}
