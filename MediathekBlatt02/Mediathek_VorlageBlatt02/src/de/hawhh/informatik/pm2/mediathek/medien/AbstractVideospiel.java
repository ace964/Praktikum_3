package de.hawhh.informatik.pm2.mediathek.medien;

import de.hawhh.informatik.pm2.mediathek.fachwerte.Geldbetrag;

/**
 * AbstractVideospiel ist ein Medium mit einer zusätzlichen Informationen zum
 * kompatiblen System.
 * 
 * @author SE2-Team, PR2-Team, PR2-Team
 * @version SoSe 2017
 */
public abstract class AbstractVideospiel extends AbstractMedium
{
    private String _system; // Das System, auf dem das Spiel lauffähig ist
    private static final int BASISPREIS = 200; // Basispreis in Eurocent

    /**
     * Initialisiert ein neues Videospiel.
     * 
     * @param titel
     *            Der Titel des Spiels
     * @param kommentar
     *            Ein Kommentar zum Spiel
     * @param system
     *            Die Bezeichnung des System
     * 
     * @require titel != null
     * @require kommentar != null
     * @require system != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSystem() == system
     */
    public AbstractVideospiel(String titel, String kommentar, String system)
    {
        super(titel, kommentar);
        assert system != null : "Vorbedingung verletzt: system != null";
        _system = system;
    }

    /**
     * Gibt das System zurück, auf dem das Spiel lauffähig ist.
     * 
     * @return Das System, auf dem das Spiel ausgeführt werden kann.
     * 
     * @ensure result != null
     */
    public String getSystem()
    {
        return _system;
    }

    @Override
    public String toString()
    {
        return getFormatiertenString();
    }

    @Override
    public String getFormatiertenString()
    {
        return super.getFormatiertenString() + "System: " + _system + "\n";
    }

    @Override
    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
        return Geldbetrag.get(BASISPREIS + getPreisNachTagen(mietTage));
    }

    protected abstract int getPreisNachTagen(int tage);
}
