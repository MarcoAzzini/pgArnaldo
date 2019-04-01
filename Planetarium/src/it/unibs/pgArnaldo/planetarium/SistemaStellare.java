package it.unibs.pgArnaldo.planetarium;

import java.util.*;

public class SistemaStellare {
	private String nome;
	private Stella stella;
	private ArrayList<Pianeta> lista_pianeti = new ArrayList<Pianeta>();
	private ArrayList<Luna> lista_lune = new ArrayList<Luna>();

	public SistemaStellare(String nome) {
		this.nome = nome;
	}

	public void setStella(Stella stella) {
		this.stella = stella;
	}

	public void aggiungiPianeta(Pianeta pianeta) {
		lista_pianeti.add(pianeta);
	}

	public void aggiungiLuna(Luna luna) {
		lista_lune.add(luna);
		luna.getPianeta().aggiungiLuna(luna);
	}

	public void rimuoviPianeta(Pianeta pianeta) {
		if(lista_pianeti.remove(pianeta))
			System.out.print("Il pianeta " + pianeta.getNome() + " e' stato rimosso con successo dal Sistema Stellare");
		else
			System.out.print("Rimozione del pianeta fallita");
	}
	

	public void rimuoviLuna(Luna luna) {
		if(lista_lune.remove(luna))
			System.out.print("La luna " + luna.getNome() + " e' stata rimossa con successo dal Sistema Stellare");
		else
			System.out.print("Rimozione della luna fallita");

	}

	public void ricercaPianeta(Pianeta pianeta) {
		if(lista_pianeti.contains(pianeta))
			System.out.print("Il pianeta " + pianeta.getNome() + " appartiene al Sistema Stellare");
		else
			System.out.print("Il codice inserito non corrisponde a nessun pianeta del Sistema Stellare");
	}

	public void ricercaLuna(Luna luna) {
		if(lista_lune.contains(luna)) {
			System.out.print("La luna " + luna.getNome() + " appartiene al Sistema Stellare. ");
			System.out.print("Gira attorno al pianeta: " + luna.getPianeta().getNome());
		}
		else
			System.out.print("Il codice inserito non corrisponde a nessuna luna del Sistema Stellare");
	}

	public double CalcolaCMX() {
		double sommaMasse = 0;
		double sommaPos = 0;
		int k = 0;
		for (int i = 0; i < lista_pianeti.size(); i++) {
			sommaMasse = sommaMasse + lista_pianeti.get(i).getMassa();
			sommaPos = sommaPos + (lista_pianeti.get(i).getCoordinata(k) * lista_pianeti.get(i).getMassa());
		}
		return sommaMasse / sommaPos;
	}

	public double CalcolaCMY() {
		double sommaMasse = 0;
		double sommaPos = 0;
		int k = 1;
		for (int i = 0; i < lista_pianeti.size(); i++) {
			sommaMasse = sommaMasse + lista_pianeti.get(i).getMassa();
			sommaPos = sommaPos + (lista_pianeti.get(i).getCoordinata(k) * lista_pianeti.get(i).getMassa());
		}
		return sommaMasse / sommaPos;
	}

	public String getNome() {
		return nome;
	}

	public Pianeta getPianeta(int codice) {
		for (int i = 0; i < lista_pianeti.size(); i++) {
			if (lista_pianeti.get(i).getCodice() == codice)
				return lista_pianeti.get(i);
		}
		return null;
	}
	
	public Luna getLuna(int codice) {
		for (int i = 0; i < lista_lune.size(); i++) {
			if (lista_lune.get(i).getCodice() == codice)
				return lista_lune.get(i);
		}
		return null;
	}

}
