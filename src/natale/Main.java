package natale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Inserimento partecipanti...");
		inserting();

	}

	private static void inserting() {

		List<Partecipante> partecipanti = new ArrayList<Partecipante>();
		
		boolean again = true;
		Scanner scanner = new Scanner(System.in);
		String risposta;
		
	    while(again) {
	    	
	    	System.out.print("Inserire un nome: ");
	    	String nome = scanner.nextLine();
		    System.out.println("Hai inserito: " + nome);
		    
		    Partecipante soggetto = new Partecipante(nome);
		    
		    boolean esiste = false;
		    for(Partecipante p : partecipanti) {
		    	if(p.getNome().equalsIgnoreCase(nome)) {
		    		esiste = true;
		    		System.out.println(nome + " è già in lista.");
		    		soggetto = p;
		    		break;
		    	}
		    }
		    
		    if(!esiste) {
		    	partecipanti.add(soggetto);
		    }
		    
		    //TODO
		    //Inserire multipli vietati
		    System.out.println(soggetto.getNome() + " ha qualcuno a cui NON può fare il regalo (y/n)?");
		    risposta = scanner.nextLine();
		    if(risposta.equalsIgnoreCase("y")) {
		    	System.out.println("Inserisci il nome di una persona a cui " + soggetto.getNome() + " NON può fare il regalo: ");
		    	String destinatarioVietato = scanner.nextLine();
		    	System.out.println("Hai inserito: " + destinatarioVietato);
		    	
			    Partecipante vietato = new Partecipante(destinatarioVietato);
			    esiste = false;
			    for(Partecipante p : partecipanti) {
			    	if(p.getNome().equalsIgnoreCase(destinatarioVietato)) {
			    		esiste = true;
			    		System.out.println(destinatarioVietato + " è già in lista; aggiornato.");
			    		vietato = p;
			    		break;
			    	}
			    }
			    if(!esiste) {
			    	partecipanti.add(vietato);
			    }
		    	
			    soggetto.addVietato(vietato);
		    	
		    }
		    
		    
		    System.out.println("Inserire qualcun altro (y/n)?");
		    risposta = scanner.nextLine();
		    if(!risposta.equalsIgnoreCase("y")) {
		    	again = false;
		    }
		    
	    }
	    
	    System.out.println("Fine inserimento.");
	    
	    for(Partecipante p : partecipanti) {
	    	System.out.println(p.toString());
	    }
	    
	    scanner.close();
		
	}

}
