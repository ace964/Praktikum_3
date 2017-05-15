package mediathek.medien;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CDTest extends AbstractMediumTest
{

	private static final String INTERPRET = "CD Interpret";
	private static final int LAENGE = 100;

	@Test
	public void testCD()
	{
		assertEquals(LAENGE, ((CD) _medium1).getSpiellaenge());
		assertEquals(INTERPRET, ((CD) _medium1).getInterpret());
	}

	@Test
	public final void testCDSetter()
	{
		((CD) _medium1).setInterpret("Interpret2");
		assertEquals(((CD) _medium1).getInterpret(), "Interpret2");
		((CD) _medium1).setSpiellaenge(99);
		assertEquals(((CD) _medium1).getSpiellaenge(), 99);
	}

	@Test
	public void testGetMedienBezeichnung()
	{
		assertEquals("CD", _medium1.getMedienBezeichnung());
	}
	
	protected CD getMedium()
	{
		return new CD(TITEL, KOMMENTAR, INTERPRET, LAENGE);
	}

}
