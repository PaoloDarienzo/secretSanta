package natale2018;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random;

public class Main {
	
	private static boolean doItAgain = false;
	
	private static List<String> participants = new ArrayList<String>();
	private static Set<String> picked = new HashSet<String>();
	
	private static Map<String, String> couples = new HashMap<String, String>();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		fillListParticipants();
		
		System.out.println("Number participants: " + participants.size());	
		System.out.println(participants.toString());
		
		do {
			assignCouples();
		}
		while(doItAgain);

		System.out.println("Done!");
		if(couples.size() != participants.size()) {
			System.out.println("ERRORE");
			return;
		}
		for(Entry<String, String> entry : couples.entrySet()) {
        	//System.out.println(entry.getKey() + " ---> \t\t" + entry.getValue());
			PrintWriter writer = new PrintWriter(entry.getKey(), "UTF-8");
			writer.println("Gentile " + entry.getKey() + ", Buon Natale!");
			writer.println("La sua persona è stata designata Babbo Natale segreto di " + entry.getValue()
			+ "!");
			writer.println("Buon divertimento!");
			writer.close();
        }
		

	}
	
	private static void assignCouples(){
				
		for(String partecipante : participants) {
			
			Set<String> compatibili = new HashSet<String>();
			
			compatibili.addAll(participants);
			compatibili.remove(partecipante); //rimuovo me
			compatibili.removeAll(picked); //rimuovo quelli gia' pescati
			
			//casi speciali
			if(partecipante.equals("Paolo")) {
				compatibili.remove("Lucia");
			}
			else if(partecipante.equals("Lucia")) {
				compatibili.remove("Paolo");
				compatibili.remove("Matteo");
			}
			else if(partecipante.equals("Denis")) {
				compatibili.remove("Martina");
				compatibili.remove("Emil");
			}
			else if(partecipante.equals("Martina")) {
				compatibili.remove("Denis");
			}
			else if(partecipante.equals("Flo")) {
				compatibili.remove("Elena");
			}
			else if(partecipante.equals("Matteo")) {
				compatibili.remove("Elena");
			}
			else if(partecipante.equals("Elena")) {
				compatibili.remove("Matteo");
			}
			else if(partecipante.equals("Lorenzo")) {
				compatibili.remove("Gaia");
				compatibili.remove("Lucia");
			}
			else if(partecipante.equals("Gaia")) {
				compatibili.remove("Lorenzo");
			}
			else if(partecipante.equals("Alberto")) {
				compatibili.remove("Leonardo");
			}
			
			if(!compatibili.isEmpty()) {
				//Genero un random
				Random rand = new Random();
				int n = rand.nextInt(compatibili.size());
				//Estraggo la persona
				List<String> papabili = new ArrayList<String>();
				papabili.addAll(compatibili);
				String receiver = papabili.get(n);
				
				//Assegno la persona al babbo natale
				couples.put(partecipante, receiver);
				picked.add(receiver);

			}
			else {
				//la lista di compatibilita'e' vuota
				//non ci sono soluzioni, e' tutto da rifare
				couples.clear();
				picked.clear();
				doItAgain = true;
				return;
			}
			
		}

	}

	private static void fillListParticipants() {
		
		participants.add("Paolo");
		participants.add("Alberto");
		participants.add("Denis");
		participants.add("Elena");
		participants.add("Lorenzo");
		participants.add("Matteo");
		participants.add("Andrea");
		participants.add("Ciompi");
		participants.add("Emil");
		participants.add("Federica");
		participants.add("Federico Bianchi");
		participants.add("Federico Marchi");
		participants.add("Flora");
		participants.add("Gaia");
		participants.add("Leonardo");
		participants.add("Lucia");
		participants.add("Mirko");
		participants.add("Ferra");
		participants.add("Stecca");
		participants.add("Martina");
		participants.add("Giuliez");
		
	}

}
