package de.gds.lottoobj;

import java.util.ArrayList;

public class Frage
{
	private String text;
	private ArrayList<Antwort> antworten = new ArrayList<Antwort>();

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Antwort> getAntworten() {
		return antworten;
	}

	public void addAntwort(Antwort antwort) {
		antworten.add(antwort);
	}

	@Override
	public String toString() {
		StringBuilder fullText = new StringBuilder(text);
		fullText.append(System.lineSeparator());
		fullText.append("------------------------------------");
		fullText.append(System.lineSeparator());
		for(Antwort antwort: antworten) {
			fullText.append(antwort);

			fullText.append(System.lineSeparator());
		}
		return fullText.toString();
	}


}
// Text  / Antworten /