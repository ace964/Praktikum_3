import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AbstractVideospielTest extends AbstractMediumTest
{

	protected static final String KOMMENTAR = "Kommentar";
    protected static final String TITEL = "Titel";
    protected static final String BEZEICHNUNG = "Videospiel";
    protected final String SYSTEM;
 

    public AbstractVideospielTest(String system)
    {
    	SYSTEM = system;
    }

    @Test
    public void testAbstractVideospiel()
    {
    	AbstractVideospiel medium = (AbstractVideospiel) _medium1;
        assertEquals(SYSTEM, medium.getSystem());
    }


    @Test
    public final void testSetKommentar()
    {
        AbstractVideospiel medium = (AbstractVideospiel) _medium1;
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }


	@Test
	public abstract void testGetMedienBezeichnung();
	
    @Test
    public abstract void testBerechneMietgebuehr();

    protected abstract AbstractVideospiel getMedium();


}
