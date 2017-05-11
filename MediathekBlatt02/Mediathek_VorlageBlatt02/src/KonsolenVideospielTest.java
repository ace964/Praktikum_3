
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 */
public class KonsolenVideospielTest extends AbstractVideospielTest
{

    public KonsolenVideospielTest()
    {
    	super(" Wii  ");
    }
    
    @Override
    protected AbstractVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, " Wii  ");
    }
    
	@Test
	public void testGetMedienBezeichnung()
	{
		assertEquals("KonsolenVideospiel", _medium1.getMedienBezeichnung());
	}

    @Test
    public void testBerechneMietgebuehr()
    {
    	KonsolenVideospiel videospiel = (KonsolenVideospiel) _medium1;
        assertEquals(videospiel.berechneMietgebuehr(2).getEuroAnteil(), 2);
        assertEquals(videospiel.berechneMietgebuehr(2).getCentAnteil(), 0);
        
        assertEquals(videospiel.berechneMietgebuehr(3).getEuroAnteil(), 9);
        assertEquals(videospiel.berechneMietgebuehr(3).getCentAnteil(), 0);

        assertEquals(videospiel.berechneMietgebuehr(5).getEuroAnteil(), 9);
        assertEquals(videospiel.berechneMietgebuehr(5).getCentAnteil(), 0);
        
        assertEquals(videospiel.berechneMietgebuehr(6).getEuroAnteil(), 16);
        assertEquals(videospiel.berechneMietgebuehr(6).getCentAnteil(), 0);
    }
}
