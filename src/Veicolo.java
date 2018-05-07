import java.time.LocalDate;

public class Veicolo 
{
	private String ID;
	private String Marca;
	private String Modello;
	private int Potenza;
	private boolean pagamentoEffettuato;
	private LocalDate dataImmatricolazione ;
	
	
	public Veicolo (String ID , String Marca, String Modello,int Potenza,int Anno,int Mese,int Giorno )
	{
		setID(ID);
		setMarca(Marca);
		setModello(Modello);
		setPotenza(Potenza);
		pagamentoEffettuato=false;
		setDataImmatricolazione(LocalDate.of(Anno,Mese,Giorno));
	}


	//GETTER AND SETTER ID
	public String getID() 
	{
		return ID;
	}
	public void setID(String iD) 
	{
		ID = iD;
	}

	//GETTER AND SETTER MARCA
	public String getMarca() 
	{
		return Marca;
	}
	public void setMarca(String marca) 
	{
		Marca = marca;
	}

	//GETTER AND SETTER MODELLO
	public String getModello() 
	{
		return Modello;
	}
	public void setModello(String modello) 
	{
		Modello = modello;
	}

	//GETTER AND SETTER POTENZA
	public int getPotenza() 
	{
		return Potenza;
	}
	public void setPotenza(int potenza) 
	{
		Potenza = potenza;
	}

	//GETTER AND SETTER PAGAMENTOEFFETTUATO
	public boolean isPagamentoEffettuato() 
	{
		return pagamentoEffettuato;
	}
	public void setPagamentoEffettuato(boolean pagamentoEffettuato) 
	{
		this.pagamentoEffettuato = pagamentoEffettuato;
	}
	
	public String toString()
	{
		return(getID() + " " + getMarca() + " " + getModello() + " " + getPotenza());
	}


	public LocalDate getDataImmatricolazione() 
	{
		return dataImmatricolazione;
	}


	public void setDataImmatricolazione(LocalDate dataImmatricolazione) 
	{
		this.dataImmatricolazione = dataImmatricolazione;
	}
	
	
	
}


