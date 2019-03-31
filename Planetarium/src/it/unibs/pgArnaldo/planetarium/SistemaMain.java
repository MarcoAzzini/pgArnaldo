package it.unibs.pgArnaldo.planetarium;
import it.unibs.fp.mylib.*;

public class SistemaMain {
	public final static String[] MENU1 = new String[] {"Gestisci Sistema Stellare",
			"Visualizza info su Corpo"};
	public final static String[] MENU2 = new String[] {"Ricerca Corpo",
			"Aggiungi Corpo", "Rimuovi Corpo"};

	public static void main(String[] args) {
		Stella stella;
		SistemaStellare sistema;
		sistema = creaSistema();
		stella = creaStella(sistema);

	}
	public static MyMenu creaMenu(String titolo, String [] voci) {
		return new MyMenu(titolo, voci);
	}
	public static SistemaStellare creaSistema() {
		String nome = InputDati.leggiStringa("Ciao,"
				+ " inserisci il nome del tuo Sistema Stellare ");
		return new SistemaStellare(nome);
	}
	public static Stella creaStella(SistemaStellare sistema) {
		String nome = InputDati.leggiStringa(" Inserisci ora il "
				+ "nome della sua Stella");
		int codice = InputDati.leggiIntero(" Inserisci il codice della stella ");
		double massa = InputDati.leggiDouble(" Inserisci la massa della stella ");
		double posizione[] = new double[] {0, 0};
		return new Stella(sistema, nome, codice, massa, posizione[0], posizione[1]);
	}
}
