package it.unibs.pgArnaldo.planetarium;

public class CorpoCeleste {
protected SistemaStellare sistema;	
protected String nome;
protected int codice;
protected double massa;
protected double[] posizione;

public CorpoCeleste(SistemaStellare sistema, String nome, int codice,
		double massa, double x, double y) {
	posizione = new double[2];
	this.sistema = sistema;
	this.nome = nome;
	this.codice = codice;
	this.massa = massa;
	posizione[0] = x;
	posizione[1] = y;
	}
public SistemaStellare getSistema() {
	return sistema;
}
public int getCodice() {
	return codice;
}
public double getMassa() {
	return massa;
}
public double getCoordinata(int i) {
	return posizione[i];
}
}
