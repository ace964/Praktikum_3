package mediathek.medien;

public class PCVideospiel extends AbstractVideospiel
{
	public PCVideospiel(String titel, String kommentar, String system)
	{
		super(titel, kommentar, system);
	}

	@Override
	protected int getPreisNachTagen(int tage)
	{
		if (tage > 7)
		{
			if ((tage - 7) % 5 > 0)
			{
				return (((tage - 7) / 5) + 1) * 500;
			} else
			{
				return ((tage - 7) / 5) * 500;
			}
		} else
		{
			return 0;
		}
	}
	
    @Override
    public String getMedienBezeichnung()
    {
        return "PCVideospiel";
    }
}
