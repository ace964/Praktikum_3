
public class KonsolenVideospiel extends AbstractVideospiel
{
    public KonsolenVideospiel(String titel, String kommentar, String system) {
        super(titel, kommentar, system);
    }
    
    @Override
    protected int getPreisNachTagen(int tage)
    {
        return (tage/3)*700;
    }
    
    @Override
    public String getMedienBezeichnung()
    {
        return "KonsolenVideospiel";
    }
}
