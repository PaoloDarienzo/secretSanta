package natale2018;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random;

public class Main {
	
	private static List<String> participants = new ArrayList<String>();
	private static Set<String> picked = new HashSet<String>();
	
	private static Map<String, String> couples = new HashMap<String, String>();

	public static void main(String[] args) {
		
		fillListParticipants();
		
		System.out.println("Number participants: " + participants.size());	
		System.out.println(participants.toString());
		
		assignCouples();
		
		System.out.println("Done");
		System.out.println(couples.toString());
		
		for(Entry<String, String> entry : couples.entrySet()) {
        	System.out.println(entry.getKey() + " ---> \t\t" + entry.getValue());
        }
		
	}
	
	private static void assignCouples(){
				
		for(String partecipante : participants) {
			
			Set<String> compatibili = new HashSet<String>();
			
			compatibili.addAll(participants);
			compatibili.remove(partecipante); //rimuovo me
			compatibili.removeAll(picked); //rimuovo quelli già pescati
			
			//casi speciali
			if(partecipante.equals("Paolo")) {
				compatibili.remove("Lucia");
				compatibili.remove("Herry");
			}
			else if(partecipante.equals("Lucia")) {
				compatibili.remove("Paolo");
				compatibili.remove("Teo");
			}
			else if(partecipante.equals("Denis")) {
				compatibili.remove("Martina");
			}
			else if(partecipante.equals("Martina")) {
				compatibili.remove("Denis");
			}
			else if(partecipante.equals("Herry")) {
				compatibili.remove("Flo");
			}
			else if(partecipante.equals("Flo")) {
				compatibili.remove("Herry");
			}
			else if(partecipante.equals("Teo")) {
				compatibili.remove("Elena");
			}
			else if(partecipante.equals("Elena")) {
				compatibili.remove("Teo");
			}
			else if(partecipante.equals("Riccio")) {
				compatibili.remove("Gaia");
			}
			else if(partecipante.equals("Gaia")) {
				compatibili.remove("Riccio");
			}
			else if(partecipante.equals("Federico Grigolini")) {
				compatibili.remove("Chiara");
			}
			else if(partecipante.equals("Chiara")) {
				compatibili.remove("Federico Grigolini");
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
				//la lista di compatibilità è vuota
				//non ci sono soluzioni, e' tutto da rifare
				couples.clear();
				picked.clear();
			}
			
		}

	}

	private static void fillListParticipants() {
		
		participants.add("Paolo");
		participants.add("Elena");
		participants.add("Teo");
		participants.add("Herry");
		participants.add("Lucia");
		participants.add("Flo");
		participants.add("Riccio");
		participants.add("Gaia");
		participants.add("Denis");
		participants.add("Martina");
		participants.add("Alberto");
		participants.add("Giuliez");
		participants.add("Andrea");
		participants.add("Chiara");
		participants.add("Ciompi");
		participants.add("Emil");
		participants.add("Federica");
		participants.add("Federico Bianchi");
		participants.add("Federico Grigolini");
		participants.add("Federico Marchi");
		participants.add("Leonardo");
		participants.add("Mirko");
		participants.add("Olly");
		participants.add("Ferra");
		participants.add("Stecca");
		
	}

}
