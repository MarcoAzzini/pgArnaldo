package it.unibs.pgArnaldo.planetarium;

import java.util.*;

public class Pianeta extends CorpoCeleste {
	private ArrayList<Luna> lista_lune = new ArrayList<Luna>();

	public Pianeta(SistemaStellare sistema, String nome, int codice, double massa, double x, double y) {
		super(sistema, nome, codice, massa, x, y);
	}

	public void aggiungiLuna(Luna luna) {
		lista_lune.add(luna);
	}

	public Luna getLuna(int i) {
		return lista_lune.get(i);
	}

	public int getNumLune() {
		return lista_lune.size();
	}

	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Nome = " + nome);
		descrizione.append("\nSistema Stellare  = " + sistema.getNome());
		descrizione.append("\nMassa = " + massa);
		descrizione.append("\nPosizione = ( " + posizione[0] + ", " + posizione[1] + ")");
		descrizione.append("\nLune che orbitano intorno:");
		for (int i = 0; i < lista_lune.size(); i++)
			descrizione.append("\n" + lista_lune.get(i).getNome());
		return descrizione.toString();
	}

	public String getNome() {
		return nome;
	}
}
