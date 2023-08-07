package de.gds.Lotto_daten_lesen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Frage {
	
	

	public Frage(){

        String line = "";
        final String delimiter = ";";
        try
        {
            String filePath = "C:/dev/workspaces/Lotto_daten_lesen/src/de/gds/Lotto_daten_lesen/fragen.csv";
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   // läuft so lange weiter bis keine Daten mehr vorhanden sind
            {
               String[] kennung = line.split(delimiter);    // Trennzeichenerkennung Semicolon
             System.out.println(kennung[0] + " | "+ kennung[1]+ " | "+ kennung[2]+ " | "+ kennung[3]);  // kennung[0] = ID , kennung[1] = Sorte, ...
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

	public Object getAntworten() {
		// TODO Auto-generated method stub
		return null;
	}

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
