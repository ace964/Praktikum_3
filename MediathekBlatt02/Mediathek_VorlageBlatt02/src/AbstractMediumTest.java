import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AbstractMediumTest
{

    protected static final String KOMMENTAR = "Kommentar";
    protected static final String TITEL = "Titel";
    protected static final String BEZEICHNUNG = "Bezeichnung";
    protected AbstractMedium _medium1;
    protected AbstractMedium _medium2;

    public AbstractMediumTest()
    {
        _medium1 = getMedium();
        _medium2 = getMedium();
    }
    
    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _medium1.getTitel());
        assertEquals(KOMMENTAR, _medium1.getKommentar());
    }

    @Test
    public final void testSetter()
    {
        _medium1.setTitel("Titel2");
        assertEquals(_medium1.getTitel(), "Titel2");
        _medium1.setKommentar("Kommentar2");
        assertEquals(_medium1.getKommentar(), "Kommentar2");
    }

    /**
     * Von ein und dem selben Medium kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    @Test
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare des gleichen Mediums sind ungleich", _medium1.equals(_medium2));
        assertTrue("Dasselbe Exemplare der gleichen Mediums ist gleich", _medium1.equals(_medium1));
    }

    @Test
    public final void testGetFormatiertenString()
    {
        Medium medium = getMedium();
        assertNotNull(medium.getFormatiertenString());
    }

    @Test
    public void testBerechneMietgebuehr()
    {
        assertEquals(_medium1.berechneMietgebuehr(10).getEuroAnteil(),30);
        assertEquals(_medium1.berechneMietgebuehr(10).getCentAnteil(),0);
        
        assertEquals(_medium1.berechneMietgebuehr(16).getEuroAnteil(),48);
        assertEquals(_medium1.berechneMietgebuehr(16).getCentAnteil(),0);
        
    }
    
    @Test
    public abstract void testGetMedienBezeichnung();
    
    protected abstract AbstractMedium getMedium();

}
