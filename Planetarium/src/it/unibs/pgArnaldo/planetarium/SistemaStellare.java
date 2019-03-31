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
public void rimuoviPianeta(int codice) {
	for (int i = 0; i < lista_pianeti.size(); i++)
		if (lista_pianeti.get(i).getCodice() == codice) {
		lista_pianeti.remove(i);
		for (int k = 0; k < lista_lune.size(); k++) {
			if(lista_lune.get(k).getPianeta().getCodice() == codice) {
				lista_lune.remove(k);
				k--;
			}
		}
		}
	}
public void ricercaPianeta (int codice) {
	int k = 0;
	for(int i = 0; i < lista_pianeti.size(); i++) {
		if(lista_pianeti.get(i).getCodice() == codice)
			System.out.print("Il pianeta "+ codice + " appartiene al Sistema Stellare");
		k = 1;
	}
	if(k == 0)
		System.out.print("Il pianeta " + codice + " non appartiene al Sistema Stellare");
	
}
public void ricercaLuna (int codice) {
	int k = 0;
	for(int i = 0; i < lista_lune.size(); i++) {
		if(lista_lune.get(i).getCodice() == codice)
			System.out.print("La luna "+ codice + " appartiene al Sistema Stellare");
		k = 1;
	}
	if(k == 0)
		System.out.print("La luna " + codice + " non appartiene al Sistema Stellare");
	
}
public double CalcolaCMX() {
	double sommaMasse = 0;
	double sommaPos = 0;
	int k = 0;
	for(int i = 0; i < lista_pianeti.size(); i++) {
		sommaMasse = sommaMasse + lista_pianeti.get(i).getMassa();
		sommaPos = sommaPos + (lista_pianeti.get(i).getCoordinata(k) * lista_pianeti.get(i).getMassa());
	}
	return sommaMasse/sommaPos;
}
public double CalcolaCMY() {
	double sommaMasse = 0;
	double sommaPos = 0;
	int k = 1;
	for(int i = 0; i < lista_pianeti.size(); i++) {
		sommaMasse = sommaMasse + lista_pianeti.get(i).getMassa();
		sommaPos = sommaPos + (lista_pianeti.get(i).getCoordinata(k) * lista_pianeti.get(i).getMassa());
	}
	return sommaMasse/sommaPos;
}
public String getNome() {
	return nome;
}
}

