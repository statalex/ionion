package gr.rege.ionion.unit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ByteUnitTest 
{

	@Test public void testParseWithoutSymbol()	{ testCreation( new ByteQty("128"), 128, ""); }
	@Test public void testParseKilo()			{ testCreation( new ByteQty("128K"), 128, "K"); }
	@Test public void testParseMega()			{ testCreation( new ByteQty("128M"), 128, "M"); }
	@Test public void testParseGiga()			{ testCreation( new ByteQty("128G"), 128, "G"); }
	@Test public void testParsePercentage()		{ testCreation( new ByteQty("128%"), 128, "%"); }
	@Test public void testParseErrror()			{ testCreation( new ByteQty("128A"), 128, ""); }

	public void testCreation( ByteQty qty, int size, String symbol) 
	{
		assertEquals(size, qty.getQuantity());
		assertEquals(symbol, qty.getFactor().getSymbol());
	}

}
