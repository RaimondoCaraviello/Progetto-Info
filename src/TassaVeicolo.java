
public class TassaVeicolo 
{
	private final int tassa = 10;
	private int potenzaVeicolo;
	private int tassaCalcolata;
	
	public TassaVeicolo()
	{
		
	}
	
	public void CalcolaTassa(int tassa,Veicolo auto) 
	{
		potenzaVeicolo = auto.getPotenza();
		tassaCalcolata= tassa*potenzaVeicolo;
	}
}
