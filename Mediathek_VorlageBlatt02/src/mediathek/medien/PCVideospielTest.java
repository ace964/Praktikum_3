package mediathek.medien;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 */
public class PCVideospielTest extends AbstractVideospielTest
{

    public PCVideospielTest()
    {
        super("WindowsXP/Vista");
    }


    
    @Override
    protected AbstractVideospiel getMedium()
    {
        return new PCVideospiel(TITEL, KOMMENTAR, "WindowsXP/Vista");
    }

    
	@Test
	public void testGetMedienBezeichnung()
	{
		assertEquals("PCVideospiel", _medium1.getMedienBezeichnung());
	}

	
    @Test
    public void testBerechneMietgebuehr()
    {
    	PCVideospiel videospiel = (PCVideospiel) _medium1;
        assertEquals(videospiel.berechneMietgebuehr(1).getEuroAnteil(), 2);
        assertEquals(videospiel.berechneMietgebuehr(1).getCentAnteil(), 0);

        assertEquals(videospiel.berechneMietgebuehr(7).getEuroAnteil(), 2);
        assertEquals(videospiel.berechneMietgebuehr(7).getCentAnteil(), 0);

        assertEquals(videospiel.berechneMietgebuehr(8).getEuroAnteil(), 7);
        assertEquals(videospiel.berechneMietgebuehr(8).getCentAnteil(), 0);

        assertEquals(videospiel.berechneMietgebuehr(12).getEuroAnteil(), 7);
        assertEquals(videospiel.berechneMietgebuehr(12).getCentAnteil(), 0);

        assertEquals(videospiel.berechneMietgebuehr(13).getEuroAnteil(), 12);
        assertEquals(videospiel.berechneMietgebuehr(13).getCentAnteil(), 0);
    }
}
