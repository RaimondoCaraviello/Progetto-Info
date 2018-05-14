import java.io.Serializable;
/**
 * Classe Nodo con metodi per la gestione
 * @author UTENTE
 *
 */
public class Nodo implements Serializable
{
	private Veicolo info;
	private Nodo link;
	/**
	 * Metodo Costruttore
	 * @param auto
	 */
	public Nodo(Veicolo auto)
	{
		setInfo(auto);
		link=null;
	}
	/**
	 * Ritorna la componente informativa del nodo
	 * @return info
	 */
	public Veicolo getInfo() 
	{
		return info;
	}
	/**
	 * Settare la componente informativa del nodo
	 * @param info
	 */
	public void setInfo(Veicolo info) 
	{
		this.info = info;
	}
	/**
	 * Metodo che ritorna il link di un nodo
	 * @return
	 */
	public Nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo che permette di settare il link di un nodo
	 * @param link
	 */
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
}
