package mediathek.medien;

import mediathek.fachwerte.Geldbetrag;

/**
 * Eine Abstrakte Klasse, die das Interface Medium bedient.
 * 
 * @author Frederic Dlugi, Maximilian Mang
 * @version SoSe 2017
 */

public abstract class AbstractMedium implements Medium
{
    private String _kommentar; // Ein Kommentar zum Medium

    private String _titel; // Der Titel des Mediums

    protected AbstractMedium(String titel, String kommentar)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _titel = titel;
        _kommentar = kommentar;
    }

    /**
     * Gibt einen formatierten Text mit allen Eigenschaften des Mediums zurÃ¼ck.
     * Jedes Attribute steht in einer eigenen Zeile mit der Form "Attributename:
     * Attributwert". Hinweis: Ein Zeilenumbruch wird durch den Character '\n'
     * dargestellt.
     * 
     * @return Eine TextreprÃ¤sentation des Mediums.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        return getMedienBezeichnung() + ":\n" + "    " + "Titel: " + _titel + "\n" + "    " + "Kommentar: " + _kommentar + "\n" + "    ";
    }

    /**
     * Gibt den Kommentar zu diesem Medium zurÃ¼ck.
     * 
     * @return Den Kommentar zu diesem Medium.
     * 
     * @ensure result != null
     */
    public String getKommentar()
    {
        return _kommentar;
    }

    /**
     * Ã„ndert den Kommentar des Mediums
     * 
     * @param kommentar
     *            Ein Kommentar zu diesem Medium
     * 
     * @require kommentar != null
     * @ensure getKommentar() == kommentar
     */
    public void setKommentar(String kommentar)
    {
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _kommentar = kommentar;
    }

    /**
     * Gibt die Bezeichnung fÃ¼r die Medienart zurÃ¼ck.
     * 
     * @return Die Bezeichnung fÃ¼r die Medienart.
     * 
     * @ensure result != null
     */
    abstract public String getMedienBezeichnung();

    /**
     * Gibt den Titel des Mediums zurÃ¼ck.
     * 
     * @return Den Titel des Mediums
     * 
     * @ensure result != null
     */
    public String getTitel()
    {
        return _titel;
    }

    /**
     * Ã„ndert den Titel des Mediums.
     * 
     * @param titel
     *            Der Titel des Mediums
     * 
     * @require titel != null
     * @ensure getTitel() == titel
     */
    public void setTitel(String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        _titel = titel;
    }

    /**
     * Berechnet die MietgebÃ¼hr in Eurocent fÃ¼r eine angegebene Mietdauer in
     * Tagen
     *
     * @param mietTage
     *            Die Anzahl der Ausleihtage eines Mediums
     * @return Die MietgebÃ¼hr in Eurocent als Geldbetrag
     *
     * @require mietTage > 0
     *
     * @ensure result != null
     */
    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
        Geldbetrag geldbetrag = Geldbetrag.get(300*mietTage);
        return geldbetrag;
    }
}