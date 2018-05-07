
public class EccezioneVeicolo extends Exception 
{
private String messaggio;
	
	public EccezioneVeicolo(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
