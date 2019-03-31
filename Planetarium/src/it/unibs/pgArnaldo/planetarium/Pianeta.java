package it.unibs.pgArnaldo.planetarium;
import java.util.*;

public class Pianeta extends CorpoCeleste{
	private ArrayList<Luna> lista_lune = new ArrayList<Luna>();

	public Pianeta(SistemaStellare sistema, String nome, int codice, double massa, double x, double y) {
		super(sistema, nome, codice, massa, x, y);
	}
	public void aggiungiLuna(Luna luna) {
		lista_lune.add(luna);
		//nel metodo aggiungi luna del sistema stellare richiamo anche questo
		//in modo da modificare sia la lista del sistema che quella del singolo pianeta
	}
	public Luna getLuna(int i) {
		return lista_lune.get(i);
	}
	public int getNumLune() {
		return lista_lune.size();
	}
	public StringBuffer toStrinng() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Nome = " + nome);
		descrizione.append("\nSistema Stellare  = " + sistema);
		descrizione.append("\nMassa = " + massa);
		descrizione.append("\nPosizione = ( " + posizione[0] + ", " + posizione[1]);
		return descrizione;
	}
	public String getNome() {
		return nome;
	}
}
