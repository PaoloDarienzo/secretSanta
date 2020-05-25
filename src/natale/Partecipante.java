package natale;

import java.util.ArrayList;
import java.util.List;

public class Partecipante {
	
	private String nome;
	private List<Partecipante> vietati = new ArrayList<Partecipante>();
	
	public Partecipante(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Partecipante> getVietati() {
		return this.vietati;
	}

	public void setVietati(List<Partecipante> vietati) {
		this.vietati = vietati;
	}
	
	public void addVietato(Partecipante vietato) {
				
		boolean esiste = false;
	    for(Partecipante p : vietati) {
	    	if(p.getNome().equalsIgnoreCase(vietato.getNome())) {
	    		esiste = true;
	    		System.out.println(vietato.getNome() + " è già in lista vietati.");
	    		break;
	    	}
	    }
	    
	    if(!esiste) {
	    	vietati.add(vietato);
	    }
	    
	}
	
	@Override
	public String toString() {
		
		String vietati = "";
		for(Partecipante p : this.vietati) {
			vietati += " " + p.getNome() + "; ";
		}
		String finale = this.nome + " non lo farà a:" + vietati;
		return finale; 
		
	}

}
