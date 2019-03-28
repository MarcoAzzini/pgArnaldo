package it.unibs.cuorisolitari;

public class Persona {
	private String nome;
	private String cognome;
	private String nickname;
	private char sesso;
	private char orientamento;
	private int eta;
	private String[] interessi;

	public Persona(String name, String sur, String nick, char sex, char or, 
			int age, String interesse[]) {
		nome = name;
		cognome = sur;
		nickname = nick;
		sesso = sex;
		orientamento = or;
		eta = age;
		interessi = new String[3];
		interessi[0] = interesse[0];
		interessi[1] = interesse[1];
		interessi[2] = interesse[2];
		
		}
	public String getNickname(){
		return nickname;
	}
	public int getEta() {
		return eta;
	}
	public char getSesso() {
		return sesso;
	}
	public char getOrientamento() {
		return orientamento;
	}
	public String getInteressi(int i) {
		return interessi[i];
	}

}
