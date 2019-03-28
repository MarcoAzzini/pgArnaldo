package it.unibs.cuorisolitari;
import it.unibs.dati.InputDati;

public class CuoriSolitariMain {
	
	public static void saluto() {
		System.out.println("Ciao, benvenuto su Cuori Solitari");
	}
	public static void presentaInteressi() {
		System.out.println("Sport/Musica/Letteratura/Teatro/Cinema/Videogame/Altro");
		System.out.println("Ora dovrai scegliere 3 fra questi interessi, in caso non li trovi di"
				+ "tuo gradimento digita 'Altro'");
	}
	public static Persona aggiungiPersona() {
		String name = InputDati.leggiStringa("Inserisci il tuo nome: ");
		String sur = InputDati.leggiStringa("Inserisci il tuo cognome: ");
		String nick = InputDati.leggiStringa("Inserisci il tuo nickname: ");
		int eta = InputDati.leggiIntero("Quanti anni hai?");
		char sex = InputDati.leggiChar("Sei maschio o femmina? (Digita m o f) ");
		char or = InputDati.leggiChar("Ti piacciono maschi o femmine? (Digita m o f) ");
		presentaInteressi();
		String[] interesse;
		interesse = new String[3];
		int i;
		for(i = 0; i < 3; i++) {
			interesse[i] = InputDati.leggiStringa("Quali fra questi sono tuoi interessi?");
		}
		return new Persona (name, sur, nick, sex, or, eta, interesse);
	}
	public static int verificaAffinita(Persona p1, Persona p2) {
		int i, j;
		int k = 0;
		if((p1.getSesso() != p2.getOrientamento()) || (p1.getOrientamento() != p2.getSesso())) {
			return k;
			}
		if(Math.abs(p1.getEta() - p2.getEta()) > 5 || Math.abs(p2.getEta() - p1.getEta()) > 5) {
			return k;
		}
		else k = 3;
	for(i = 0; i < 3; i++) {
		for(j = 0; j < 3; j++) {
			if(p1.getInteressi(i).equals(p2.getInteressi(j))){
				k = k + 3;
			}
		}
	}
	return k;
		
	}
	public static void calcolaPercentuale(int k) {
		int p = k*10;
		System.out.printf("%d%%n", p);
	
	}

	public static void cuoriAffini(String nick1, String nick2, int k) {
		System.out.printf("%s e %s, siete affini al ", nick1, nick2);
		calcolaPercentuale(k);
	}
	public static void main(String[] args) {
		Persona[] database;
		database = new Persona[2];
		int i, j;
		for(i = 0; i < 2; i++) {
			saluto();
			database [i] = aggiungiPersona();
			}
		for(j = 1; j < 2; j++) {
			int aff = verificaAffinita(database[0], database[j]);
			cuoriAffini(database[0].getNickname(), database[j].getNickname(), aff); 
			
		}
		
		

	}

}
