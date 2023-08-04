package de.gds.lottoobj;


public class Antwort{

	private String text;
	private Frage frage;
	private int nummer ;


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		}

	public void addFolgeFrage(Frage frage) {
		this.frage = frage;
	}
	public  int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	@Override
	public String toString() {
		return nummer + " - " + text;
	}
	public Frage getFolgeFrage() {
		return frage;
	}


}

// Text / Frage