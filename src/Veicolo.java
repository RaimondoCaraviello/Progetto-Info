import java.io.Serializable;
import java.time.LocalDate;
/**
 * Classe Veicolo e metodi per la sua gestione 
 * @author Raimondo Caraviello
 *
 */
public class Veicolo implements Serializable
{
	private String ID;
	private String Marca;
	private String Modello;
	private int Potenza;
	private boolean pagamentoEffettuato;
	private LocalDate dataImmatricolazione ;
	
	//COSTRUTTORE 
	/**
	 * Metodo costruttore del veicolo
	 * @param ID
	 * @param Marca
	 * @param Modello
	 * @param Potenza
	 * @param dataImmatricolazione
	 */
	public Veicolo (String ID , String Marca, String Modello,int Potenza,LocalDate dataImmatricolazione )
	{
		setID(ID);
		setMarca(Marca);
		setModello(Modello);
		setPotenza(Potenza);
		pagamentoEffettuato=false;
		setDataImmatricolazione(dataImmatricolazione);
	}
	
	//COSTRUTTORE VUOTO
	/**
	 * Metodo costruttore vuoto
	 */
	public Veicolo()
	{
		
	}


	//GETTER AND SETTER ID
	/**
	 * Metodo che ritorna l'ID di un veicolo
	 * @return
	 */
	public String getID() 
	{
		return ID;
	}
	/**
	 * Metodo che permette di settare l'ID di un veicolo
	 * @param iD
	 */
	public void setID(String iD) 
	{
		ID = iD;
	}
	//GETTER AND SETTER MARCA
	/**
	 * metodo che ritorna la marca di un veicolo
	 * @return marca
	 */
	public String getMarca() 
	{
		return Marca;
	}
	/**
	 * Metodo che permette di settare la marca di un veicolo
	 * @param marca
	 */
	public void setMarca(String marca) 
	{
		Marca = marca;
	}

	//GETTER AND SETTER MODELLO
	/**
	 * Metodo che ritorna il modello di un veicolo
	 * @return modello
	 */
	public String getModello() 
	{
		return Modello;
	}
	/**
	 * Metodo che permette di settare il modello di un veicolo
	 * @param modello
	 */
	public void setModello(String modello) 
	{
		Modello = modello;
	}

	//GETTER AND SETTER POTENZA
	/**
	 * Metodo che ritorna il valore di potenza di un veicolo
	 * @return potenza
	 */
	public int getPotenza() 
	{
		return Potenza;
	}
	/**
	 * Metodo che permette di settare il valore di potenza di un veicolo
	 * @param potenza
	 */
	public void setPotenza(int potenza) 
	{
		Potenza = potenza;
	}

	//GETTER AND SETTER PAGAMENTOEFFETTUATO
	/**
	 * Metodo che ritorna il tipo di variabile boolean relativa al pagamento
	 * @return  se il pagamento e stato effettuato oppure no
	 */
	public boolean isPagamentoEffettuato() 
	{
		return pagamentoEffettuato;
	}
	/**
	 * Permette di settare il valore della variabile boolean di pagamento
	 * @param pagamentoEffettuato
	 */
	public void setPagamentoEffettuato(boolean pagamentoEffettuato) 
	{
		this.pagamentoEffettuato = pagamentoEffettuato;
	}
	/**
	 * Overide del toString() versione base in modo da ottenere le informazioni di cui abbiamo bisogno
	 */
	public String toString()
	{
		return(getID() + " " + getMarca() + " " + getModello() + " " + getPotenza());
	}

	/**
	 * Metodo che ritorna la data di immatricolazione di un veicolo
	 * @return data immatricolazione
	 */
	public LocalDate getDataImmatricolazione() 
	{
		return dataImmatricolazione;
	}
	/**
	 * Permette di settare la data di immatricolazione di un veicolo
	 * @param dataImmatricolazione
	 */
	public void setDataImmatricolazione(LocalDate dataImmatricolazione) 
	{
		this.dataImmatricolazione = dataImmatricolazione;
	}
	
	
	
}


