package it.unibs.pgArnaldo.planetarium;

public class Luna extends CorpoCeleste {
	private Pianeta pianeta;

	public Luna(SistemaStellare sistema, String nome, int codice, double massa, double x, double y, 
			Pianeta pianeta) {
		super(sistema, nome, codice, massa, x, y);
		this.pianeta = pianeta;
	}
	public Pianeta getPianeta() {
		return pianeta;
	}
	public StringBuffer toStrinng() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Nome = " + nome);
		descrizione.append("\nPercorso = " + sistema.getNome());
		descrizione.append("--> " + pianeta.getNome());
		descrizione.append(" --> " + nome);
		return descrizione;
	}
}
