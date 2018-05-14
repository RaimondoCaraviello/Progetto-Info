import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * Questa classe consente di gestire una lista di veicoli e di eseguire determinate operazioni su di essi
 * @author UTENTE
 *
 */
public class UfficioPratiche implements Serializable
{
	private int tassa = 10; 
	private Nodo head;
	private int elementi;
	
	/**
	 * Metodo Costruttore 
	 */
	public UfficioPratiche()
	{
		head=null;
		elementi=0;
	}
	
	//RITORNA IL NUMERO DI ELEMENTI
	/**
	 * Ritorna il numero di elementi della lista
	 * @return elementi
	 */
	public int getElementi()
	{
		return elementi;
	}

	//CI RITORNA IL LINK 
	/**
	 * Metodo che restutuisce un nodo data una posizione
	 * @param posizione posizionee da cui si vuole prendere un link
	 * @return p
	 */
	private Nodo getLinkPosizione(int posizione) 
	{
		Nodo p;
		int n;
		p = head;
		n = 1;
		
		if (posizione < 1 || posizione > getElementi())
			System.out.println("Posizione non valida");
		if (elementi==0)
			System.out.println("Lista Vuota");
			
		while(p.getLink()!= null && n < posizione)
		{
			p = p.getLink();
			n++;
		}
		
		return p;
	}
	
	//RESTITUISCE UN VEICOLO DALLA LISTA
	/**
	 * Metodo che ritrona un veicolo data la sua posizione
	 * @param posizione
	 * @return informazioni del veicolo
	 */
	public Veicolo getVeicolo (int posizione) 
	{
		if (elementi==0)
			System.out.println("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			System.out.println("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	//RICERCA DI UN VEICOLO TRAMITE ID
	/**
	 * Metodo che ricerca un veicolo tra quelli presenti tramite l'ID del veicolo
	 * @param ID
	 * @return veicolo corrispondente all'ID inserito
	 * @throws EccezioneVeicolo
	 */
	public Veicolo cercaVeicolo(String ID) throws EccezioneVeicolo
	{
		for(int i=1; i <= getElementi() ; i++)
		{
			if(ID.compareTo(getVeicolo(i).getID()) == 0 )
			{	
				return getVeicolo(i);
			}
		}
		throw new EccezioneVeicolo("Veicolo " + ID + " non presente");
	}

	//CREA NODO
	/**
	 * Metodo che serve per la creazione di un nuovo nodo 
	 * @param auto
	 * @param link
	 * @return il nuovo nodo creato
	 */
	private Nodo creaNodo(Veicolo auto, Nodo link)
	{
		Nodo nodo= new Nodo(auto);
		nodo.setLink(link);
		return nodo;
	}
	
	//INSERIMENTO ELEMENTI
	/**
	 * Crea un nuovo nodo e lo fa puntare direttamente dall'head della lista
	 * @param auto
	 */
	public void inserisciInTesta (Veicolo auto)
	{
		
		Nodo p=creaNodo(auto, head);
		head=p;
		elementi++;
	}
	/**
	 * Crea un nuovo nodo e lo inserisce nell'ultima posizione 
	 * @param auto
	 */
	public void inserisciInCoda(Veicolo auto)
	{
		if(elementi==0)
		{
			inserisciInTesta(auto);
			return;
		}
		
		Nodo pn=creaNodo(auto, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	/**
	 * Crea un nodo e lo inserisce in una posizione scelta
	 * @param auto
	 * @param posizione
	 */
	public void inseriscInPosizione(Veicolo auto,int posizione)
	{
		if (posizione<=1)
		{
			inserisciInTesta(auto);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(auto);
			return;
		}
		
		Nodo pn=creaNodo(auto, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	//ELIMINAZIONE ELEMENTI
	/**
	 * Elimina il primo elemento della lista
	 */
	public void eliminaInTesta() 
	{
		if (elementi==0)
			System.out.println("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	/**
	 * Elimina l'ultimo elemento della lista
	 */
	public void eliminaInCoda() 
	{
		if (elementi==0)
			System.out.println("Lista Vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	/**
	 * Elimina un elemento data una posizione scelta
	 * @param posizione
	 */
	public void eliminaInPosizione(int posizione) 
	{
		if (elementi==0)
			System.out.println("Lista Vuota");
		
		if (posizione<=0 || posizione>elementi)
			System.out.println("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	//Eliminazione per ID
	/**
	 * Metodo che elimina un elemento in una determinata posizione tramite ricerca per ID
	 * @param ID
	 */
	public void EliminaPerID(String ID) 
	{	
		for(int i = 1; i <= getElementi();i++)
		{
			if(ID.compareTo(getVeicolo(i).getID())==0)
			{
				eliminaInPosizione(i);
				System.out.println("Eliminazione effettuata con successo");
			}
			else if (ID.compareTo(getVeicolo(i).getID())!=0)
			{
				System.out.println("il veicolo " + ID + " non corrisponde ad un veicolo");
			}
		}
	}

	//CALCOLO TASSA PER VEICOLO
	/**
	 * Calcola la tassa relativa ad ogni veicolo in base alla sua potenza
	 * @param ID
	 * @throws EccezioneVeicolo
	 */
	public void CalcoloTassa(String ID)throws EccezioneVeicolo
	{
		int tassaCalcolata;
		Veicolo auto = cercaVeicolo(ID);
		tassaCalcolata = tassa*auto.getPotenza();
		System.out.println("La tassa relativa all ID : " + ID + " corrisponde a : " + tassaCalcolata);
	}

	//SETTAGGIO NUOVA TASSA
	/**
	 * Consente di reimpostare il valore unitario della tassa
	 * @param tassa
	 */
	public void setTassa (int tassa)
	{
		this.tassa=tassa;
	}
	
	//VERIFICA PAGAMENTO AUTO
	/**
	 * Verifica se un determinato veicolo registrato nel sistema ha effettuato il pagamento ed indica anche la data di pagamento effettuato
	 * @param ID
	 * @throws EccezioneVeicolo
	 */
	public void verificaPagamento (String ID) throws EccezioneVeicolo
	{
		Veicolo auto = cercaVeicolo(ID);
		if(auto.isPagamentoEffettuato()== true)
		{
			System.out.println("Tassa del veciolo numero : " + auto.getID() + "e' gia stata pagata il giorno: " + auto.getDataImmatricolazione());
		}
		else
		{
			System.out.println("Nessuna tassa pagata relativa a questo ID");
		}
	}
	
	//PARTE CSV (SALVATAGGIO/CARICAMENTO)
	/**
	 * Metodo che permette di stampare i dati su un file di testocon tutte le caratteristiche del veicolo
	 * @param nomeFile
	 * @param ID
	 * @throws IOException
	 * @throws EccezioneVeicolo
	 * @throws FileException
	 */
	public void esportaCSV (String nomeFile,String ID) throws IOException, EccezioneVeicolo, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String autoCSV;
		Veicolo auto;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			auto=cercaVeicolo(ID);
			autoCSV=auto.getID() + '\n' + auto.getMarca() + '\n' + auto.getModello()+ '\n' + auto.getPotenza() +  '\n' + auto.isPagamentoEffettuato() + '\n' + auto.getDataImmatricolazione();
			file.toFile(autoCSV);
		}
		file.closeFile();
		
	}

	//SIMULAZIONE PAGAMENTO TASSA ( con esportazione su file )
	/**
	 * Metodo che permette di pagare la tassa relativa all'auto fornendo anche la data di effettivo pagamento
	 * @param ID
	 * @throws EccezioneVeicolo
	 * @throws FileException
	 * @throws IOException
	 */
	public void pagaTassa(String ID)throws EccezioneVeicolo , FileException , IOException
		{
			Veicolo auto=cercaVeicolo(ID);
			if(auto.isPagamentoEffettuato()== false)
			{
				auto.setPagamentoEffettuato(true);
				auto.setDataImmatricolazione(LocalDate.now());
				esportaCSV("Tassa.txt", ID);
				System.out.println("Tassa Pagata");
			}
			else
			{
				System.out.println("Tassa gia pagata");
			}
		}
	
	//ORDINAMENTO per ID
	/**
	 * Ordina gli elementi in base all' ID
	 */
	public void ordinamentoPerID()
	{
		for (int i = 1 ; i < getElementi() ; i++)
		{
			
			if(getVeicolo(i).getID().compareTo(getVeicolo(i+1).getID())<0)
			{
				i++;
			}
			else if(getVeicolo(i).getID().compareTo(getVeicolo(i+1).getID())>0)
			{
				inseriscInPosizione(getVeicolo(i+1),i);
				eliminaInPosizione(i+2);
			}
		}
		for (int i = 1; i <= getElementi() ; i++)
		{
			System.out.println(getVeicolo(i));
		}
		
	}
	
	//ORDINA PER ORARIO
	/**
	 * Ordina gli elementi per data di immatricolazione
	 */
	public void OrdinamentoPerData()
	{
		//Poichè LocalDate.now permette di prendere l'orario effettivo dell'immatricolazione 
		//ogni nuovo veicolo sarà per forza ordinato per orario
		
		for (int i = 1; i <= getElementi() ; i++)
		{
			System.out.println(getVeicolo(i));
		}
	}
	/**
	 * Serializza i dati
	 * @param nomeFile
	 * @throws IOException
	 */
	public void salvaListaPagamenti(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Deserializza i dati salvati
	 * @param nomeFile
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public UfficioPratiche caricaListaPagamenti (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		UfficioPratiche lista;
		
		lista=(UfficioPratiche)(reader.readObject());
		file.close();
		return lista;
	}
	
	
	
	
	
	

}
	
	
	

