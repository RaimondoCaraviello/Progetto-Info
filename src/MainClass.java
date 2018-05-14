import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class MainClass 
{
	public static void main(String[] args) throws EccezioneVeicolo, FileException, IOException, ClassNotFoundException 
	{
		int scelta = 0;
		UfficioPratiche lista = new UfficioPratiche();
		
		System.out.println("Benvenuto nel Software di gestione delle pratiche automobilistiche;" + '\n');
		
		do
		{
			System.out.println("Digita il numero correlato all'operazione che vuoi effettuare : " + '\n');
			System.out.println("1--> Aggiungere un veicolo " + '\n' + "2--> Eliminare un Veicolo" + '\n' + "3--> Calcola la tassa relativa alla tua auto" + '\n' + "4--> Paga la tassa della tua auto" + '\n' + "5--> Verifica il tuo pagamento" + '\n' + "6--> Mostra elenco veicolo per ID" + '\n' + "7--> Mostra elencoveicolo per data di immatricolazione" + '\n' + "8--> Carica dati salvati " + '\n' + "9--> Salva i dati" + '\n' + "10-->Terminazione del programma");
		
		
			Scanner tastiera = new Scanner(System.in);
			scelta = tastiera.nextInt();
			
			if(scelta == 0 || scelta > 10)
			{
				System.out.println("Valore non valido,inserisci nuovamente il valore : ");
				scelta = tastiera.nextInt();
			}
		
			else if (scelta == 1) //AGGIUNGI AUTO
			{
				tastiera.nextLine();
				Veicolo auto = new Veicolo();
				System.out.println("Inserisci l'ID");
				auto.setID(tastiera.nextLine());
				System.out.println("Inserisci la marca");
				auto.setMarca(tastiera.nextLine());
				System.out.println("Inserisci il modello");
				auto.setModello(tastiera.nextLine());
				System.out.println("Inserisci la potenza");
				auto.setPotenza(tastiera.nextInt());
				auto.setPagamentoEffettuato(false);
				auto.setDataImmatricolazione(LocalDate.now());
				lista.inserisciInTesta(auto);
			}
		
			else if (scelta == 2) //ELIMINA AUTO
			{
				tastiera.nextLine();
				System.out.println("Inserisci l'ID della macchina da eliminare");
				lista.EliminaPerID(tastiera.nextLine());
			}
			else if (scelta == 3) //CALCOLO TASSA
			{
				tastiera.nextLine();
				System.out.println("Inserisci l'ID della macchina su cui calcolare la tassa");
				lista.CalcoloTassa(tastiera.nextLine());
				
			}
			else if (scelta == 4) //PAGA TASSA
			{
				tastiera.nextLine();
				System.out.println("Inserisci l'ID della macchina su cui pagare la tassa");
				lista.pagaTassa(tastiera.nextLine());
			}
			else if (scelta == 5) //VERIFICA PAGAMENTO
			{
				tastiera.nextLine();
				System.out.println("Inserisci l'ID della macchina su cui verificare il pagamento della tassa");
				lista.verificaPagamento(tastiera.nextLine());
			}
			else if (scelta == 6) //ELENCO PER ID
			{
				tastiera.nextLine();
				lista.ordinamentoPerID();
			}
			else if (scelta == 7) //ELENCO PER DATA
			{
				tastiera.nextLine();
				lista.OrdinamentoPerData();
			}
			else if (scelta == 8) // CARICA I DATI SERIALIZZATI
			{
				System.out.println("Inserisci il file da cui prendere i dati salvati dei pagamenti");
				lista.caricaListaPagamenti(tastiera.nextLine());
			}
			
			else if (scelta == 9) // SERIALIZZA I DATI
			{
				System.out.println("Inserisci il nome del file su cui salvare i dati dei pagamenti");
				lista.salvaListaPagamenti(tastiera.nextLine());
			}
			
			else if (scelta == 10) // Chiusura programma
			{
				System.out.println("Chiusura programma in corso");
				break;
			}
			
			
		}while(scelta >= 0 || scelta <= 10);
		
	}

}
