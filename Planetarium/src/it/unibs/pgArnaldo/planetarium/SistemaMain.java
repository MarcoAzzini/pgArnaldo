package it.unibs.pgArnaldo.planetarium;

import it.unibs.fp.mylib.*;

public class SistemaMain {
	public final static String TITOLO1 = "Menu Iniziale";
	public final static String[] MENU1 = new String[] { "Gestisci Sistema Stellare", "Visualizza info su Corpo",
			"Calcola centro di massa" };
	public final static String[] MENU2 = new String[] { "Ricerca Corpo", "Aggiungi Corpo", "Rimuovi Corpo" };
	public final static String[] MENU3 = new String[] { "Ricerca Pianeta", "Ricerca Luna" };
	public final static String[] MENU4 = new String[] { "Aggiungi Pianeta", "Aggiungi Luna" };
	public final static String[] MENU5 = new String[] { "Rimuovi Pianeta", "Rimuovi Luna" };
	public final static String[] MENU6 = new String[] { "Visualizza Pianeta", "Visualizza Luna" };
	public final static String RICERCA = "Inserisci il codice";
	public final static String SALUTO = "Il programma e' terminato con successo";

	public static void main(String[] args) {
		Stella stella;
		SistemaStellare sistema;
		sistema = creaSistema();
		stella = creaStella(sistema);
		sistema.setStella(stella);
		MyMenu menu1 = creaMenu(TITOLO1, MENU1);
		MyMenu menu2 = creaMenu(MENU1[0], MENU2);
		MyMenu menu3 = creaMenu(MENU2[0], MENU3);
		MyMenu menu4 = creaMenu(MENU2[1], MENU4);
		MyMenu menu5 = creaMenu(MENU2[2], MENU5);
		MyMenu menu6 = creaMenu(MENU1[1], MENU6);
		for (int i = 0; i > -1; i++) {
			switch (menu1.scegli()) {
			case 0:
				i = -50;
				break;
			case 1:
				switch (menu2.scegli()) {
				case 0:
					break;
				case 1:
					switch (menu3.scegli()) {
					case 0:
						break;
					case 1:
						sistema.ricercaPianeta(sistema.getPianeta(InputDati.leggiIntero(RICERCA)));
						break;
					case 2:
						sistema.ricercaLuna(sistema.getLuna(InputDati.leggiIntero(RICERCA)));
						break;
					}
					break;
				case 2:
					switch (menu4.scegli()) {
					case 0:
						break;
					case 1:
						sistema.aggiungiPianeta(creaPianeta(sistema));
						break;
					case 2:
						sistema.aggiungiLuna(creaLuna(sistema));
						break;
					}
					break;
				case 3:
					switch (menu5.scegli()) {
					case 0:
						break;
					case 1:
						sistema.rimuoviPianeta(sistema.getPianeta(
								InputDati.leggiIntero("Inserisci il codice del" + " pianeta da rimuovere")));
						break;
					case 2:
						sistema.rimuoviLuna(sistema
								.getLuna(InputDati.leggiIntero("Inserisci il codice della" + " luna da rimuovere")));
						break;
					}
					break;
				}
				break;
			case 2:
				switch (menu6.scegli()) {
				case 0:
					break;
				case 1:
					visualizzaInfoPianeta(InputDati.leggiIntero("Inserisci il codice del pianeta"), sistema);
					break;
				case 2:
					visualizzaInfoLuna(InputDati.leggiIntero("Inserisci il codice della Luna"), sistema);
					break;
				}
				break;
			case 3:
				stampaCM(sistema);
				break;
			}
			if (i > 50)
				i = 1;
		}
		System.out.print(SALUTO);
	}

	public static MyMenu creaMenu(String titolo, String[] voci) {
		return new MyMenu(titolo, voci);
	}

	public static SistemaStellare creaSistema() {
		String nome = InputDati.leggiStringa("Ciao," + " inserisci il nome del tuo Sistema Stellare ");
		return new SistemaStellare(nome);
	}

	public static Stella creaStella(SistemaStellare sistema) {
		String nome = InputDati.leggiStringa(" Inserisci ora il " + "nome della sua Stella");
		int codice = InputDati.leggiIntero(" Inserisci il codice della stella ");
		double massa = InputDati.leggiDouble(" Inserisci la massa della stella ");
		double posizione[] = new double[] { 0, 0 };
		return new Stella(sistema, nome, codice, massa, posizione[0], posizione[1]);
	}

	public static Pianeta creaPianeta(SistemaStellare sistema) {
		String nome = InputDati.leggiStringa(" Inserisci il nome del pianeta");
		int codice = InputDati.leggiIntero(" Inserisci il codice del pianeta ");
		double massa = InputDati.leggiDouble(" Inserisci la massa del pianeta ");
		double posizione[] = new double[2];
		posizione[0] = InputDati.leggiDouble("Inserisci la coordinata x");
		posizione[1] = InputDati.leggiDouble("Inserisci la coordinata y");
		return new Pianeta(sistema, nome, codice, massa, posizione[0], posizione[1]);
	}

	public static Luna creaLuna(SistemaStellare sistema) {
		String nome = InputDati.leggiStringa(" Inserisci il nome della Luna ");
		int codice = InputDati.leggiIntero(" Inserisci il codice della Luna ");
		double massa = InputDati.leggiDouble(" Inserisci la massa della Luna ");
		double posizione[] = new double[2];
		posizione[0] = InputDati.leggiDouble("Inserisci la coordinata x ");
		posizione[1] = InputDati.leggiDouble("Inserisci la coordinata y ");
		int codicePianeta = InputDati.leggiIntero("Inserisci il codice del pianeta" + " attorno al quale gravita");
		return new Luna(sistema, nome, codice, massa, posizione[0], posizione[1], sistema.getPianeta(codicePianeta));
	}

	public static void visualizzaInfoPianeta(int codice, SistemaStellare sistema) {
		System.out.print(sistema.getPianeta(codice));
	}

	public static void visualizzaInfoLuna(int codice, SistemaStellare sistema) {
		System.out.print(sistema.getLuna(codice));
	}

	public static void stampaCM(SistemaStellare sistema) {
		System.out.print("Il centro di massa si trova nella posizione ( " + sistema.CalcolaCMX() + ", "
				+ sistema.CalcolaCMY() + ")");
	}
}
