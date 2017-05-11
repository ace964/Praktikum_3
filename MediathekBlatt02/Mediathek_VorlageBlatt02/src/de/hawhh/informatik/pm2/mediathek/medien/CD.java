package de.hawhh.informatik.pm2.mediathek.medien;
/**
 * Eine CD ist ein Medium. ZusÃ¤tzlich zu den Eigenschaften eines Mediums erfasst
 * sie Informationen zu SpiellÃ¤nge und Interpret.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2017
 */
public class CD extends AbstractMedium
{
    private String _interpret; //Der Interpret der CD

    private int _spiellaenge; //Die SpiellÃ¤nge der CD in Minuten


    /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel der CD
     * @param kommentar Ein Kommentar zu der CD
     * @param interpret Der Interpret der CD
     * @param spiellaenge Die Spiellaenge der CD in Minuten
     * 
     * @require titel != null
     * @require kommentar != null
     * @require interpret != null
     * @require spiellaenge > 0
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getInterpret() == interpret
     * @ensure getSpiellaenge() == spiellaenge
     */
    public CD(String titel, String kommentar, String interpret, int spiellaenge)
    {
        super(titel, kommentar);
        assert interpret != null : "Vorbedingung verletzt: interpret != null";
        assert spiellaenge > 0 : "Vorbedingung verletzt: spiellaenge > 0";
        _spiellaenge = spiellaenge;
        _interpret = interpret;
    }

    /**
     * Gibt den Interpreten der CD zurÃ¼ck.
     * 
     * @return Den Interpreten der CD.
     * 
     * @ensure result != null
     */
    public String getInterpret()
    {
        return _interpret;
    }

    /**
     * Ã„ndert den Interpreten
     * 
     * @param interpret Der Interpret des Mediums
     * 
     * @require interpret != null
     * @ensure getInterpret() == interpret
     */
    public void setInterpret(String interpret)
    {
        assert interpret != null : "Vorbedingung verletzt: interpret != null";
        _interpret = interpret;
    }

    @Override
    public String getMedienBezeichnung()
    {
        return "CD";
    }

    /**
     * Gibt die SpiellÃ¤nge (in Minuten) der CD zurÃ¼ck.
     * 
     * @return Die SpiellÃ¤nge der CD.
     * 
     * @ensure result > 0
     */
    public int getSpiellaenge()
    {
        return _spiellaenge;
    }

    /**
     * Ã„ndert die SpiellÃ¤nge
     * 
     * @param spiellaenge SpiellÃ¤nge des Medium
     * 
     * @require spiellaenge > 0
     * @ensure getSpielaenge() == spiellaenge
     */
    public void setSpiellaenge(int spiellaenge)
    {
        assert spiellaenge > 0 : "Vorbedingung verletzt: spiellaenge > 0";
        _spiellaenge = spiellaenge;
    }

    @Override
    public String getFormatiertenString()
    {
        return super.getFormatiertenString()
                + "Interpret: " + _interpret + "\n" +
                "    " + "Spiellänge: " + _spiellaenge + "\n";
    }
}
