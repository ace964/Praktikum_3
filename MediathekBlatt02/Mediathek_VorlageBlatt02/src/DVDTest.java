import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DVDTest extends AbstractMediumTest
{

    private static final int LAENGE = 100;
    private static final String REGISSEUR = "DVD Regisseur";

    @Test
    public void testDVD()
    {
        assertEquals(LAENGE, ((DVD)_medium1).getLaufzeit());
        assertEquals(REGISSEUR, ((DVD)_medium1).getRegisseur());
    }

    @Test
    public final void testDVDSetter()
    {
        assertEquals(100, ((DVD)_medium1).getLaufzeit());
        ((DVD)_medium1).setRegisseur("Regisseur2");
        assertEquals("Regisseur2", ((DVD)_medium1).getRegisseur());
    }
    

	@Test
	public void testGetMedienBezeichnung()
	{
		assertEquals("DVD", _medium1.getMedienBezeichnung());
	}

    protected DVD getMedium()
    {
        return new DVD(TITEL, KOMMENTAR, REGISSEUR, LAENGE);
    }
    
}
