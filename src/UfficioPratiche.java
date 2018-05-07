import java.io.IOException;
import java.time.LocalDate;

public class UfficioPratiche 
{
	private int tassa = 10; 
	private Nodo head;
	private int elementi;
	
	public UfficioPratiche()
	{
		head=null;
		elementi=0;
	}
	
	//RITORNA IL NUMERO DI ELEMENTI
	
	public int getElementi()
	{
		return elementi;
	}
	
	//AGGIUNGERE UN ELEMENTO NELLA LISTA
	
	public Nodo aggiungiNodo (Veicolo auto , Nodo link)
	{
		Nodo nodo = new Nodo(auto);
		nodo.setLink(link);
		return nodo;
	}

	//CI RITORNA IL LINK 
	
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
	
	public Veicolo cercaVeicolo(String ID) throws EccezioneVeicolo
	{
		for(int i=1; i <= getElementi() ; i++)
		{
			if(ID == getVeicolo(i).getID() )
			{	
				return getVeicolo(i);
			}
		}
		throw new EccezioneVeicolo("Veicolo " + ID + " non presente");
	}
	
	//ELIMINAZIONE ELEMENTI
	
	public void eliminaInTesta() 
	{
		if (elementi==0)
			System.out.println("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
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

	//CALCOLO TASSA PER VEICOLO
	
	public int CalcoloTassa(String ID)throws EccezioneVeicolo
	{
		int tassaCalcolata;
		Veicolo auto = cercaVeicolo(ID);
		tassaCalcolata = tassa*auto.getPotenza();
		return tassaCalcolata;
	}

	//SETTAGGIO NUOVA TASSA
	
	public void setTassa (int tassa)
	{
		this.tassa=tassa;
	}
	
	//VERIFICA PAGAMENTO AUTO
	
	public void verificaPagamento (String ID) throws EccezioneVeicolo
	{
		Veicolo auto = cercaVeicolo(ID);
		if(auto.isPagamentoEffettuato()== true)
		{
			System.out.println("Tassa gia pagata il giorno: " + auto.getDataImmatricolazione());
		}
		else
		{
			System.out.println("Nessuna tassa pagata relativa a questo ID");
		}
	}
	
	//PARTE CSV (SALVATAGGIO/CARICAMENTO)
	
	public void esportaCSV (String nomeFile,String ID) throws IOException, EccezioneVeicolo, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String autoCSV;
		Veicolo auto;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			auto=cercaVeicolo(ID);
			autoCSV=auto.getID()+ '\n' + auto.getMarca() + '\n' + auto.getModello()+ '\n' + auto.getPotenza() + '\n' + auto.getDataImmatricolazione() + '\n' + CalcoloTassa(ID);
			file.toFile(autoCSV);
		}
		file.closeFile();
		
	}

	//SIMULAZIONE PAGAMENTO TASSA ( con esportazione su file )
	
	public void pagaTassa(String ID)throws EccezioneVeicolo , FileException , IOException
		{
			Veicolo auto=cercaVeicolo(ID);
			if(auto.isPagamentoEffettuato()== false)
			{
				auto.setPagamentoEffettuato(true);
				auto.setDataImmatricolazione(LocalDate.now());
				esportaCSV("Tassa.txt", ID);
			}
			else
			{
				System.out.println("Tassa gia pagata");
			}
		}
	
	//METODO SCAMBIA PER L'ORDINAMENTO
	
	public static int scambia (int[] array, int pos1, int pos2)

	{
		int s;
		if (pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}			
	}
	
	//PASSAGGIO DATI DA LISTA AD ARRAY
	
	
	int elementiArray = elementi;
	private Veicolo[] elencoAuto = new Veicolo[elementiArray];
	
	
	
	
	
	
	

}
	
	
	

