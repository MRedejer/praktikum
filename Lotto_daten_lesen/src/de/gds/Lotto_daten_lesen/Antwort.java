package de.gds.Lotto_daten_lesen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Antwort {
	
	private String text;
	private Frage frage;
	private int nummer ;

	
	
	
	public Antwort(String text, Frage frage, int nummer){
		
		this.setText(text);
		this.setFrage(frage);
		this.setNummer(nummer);

        String line = "";
        final String delimiter = ";";
        try
        {
            String filePath = "C:/dev/workspaces/Lotto_daten_lesen/src/de/gds/Lotto_daten_lesen/antworten.csv";
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

	public Frage getFolgeFrage() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Frage getFrage() {
		return frage;
	}


	public void setFrage(Frage frage) {
		this.frage = frage;
	}


	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}


