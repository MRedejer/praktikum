package de.gds.Lotto_daten_lesen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.gds.Lotto_daten_lesen.Antwort;
import de.gds.Lotto_daten_lesen.Frage;

/*   To Do
 *  --------------------------------------------------
 *
 * Eclipse
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * 1.    Line 088
 * 2.    Line 111
 * 3.
 * 4.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 *
 *  To Do in Excel/Notepad++
 *  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 *
 *  akutell läuft !
 *
 *  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * ---------------------------------------------------
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException
    {

    	//List<Frage> alleFragen = new ArrayList<>();
        //List<Antwort> alleAntworten = new ArrayList<>();

    	Frage ersteFrage = init();

    	Scanner klicker = new Scanner(System.in);

    	Frage currentReadFrage = ersteFrage;


    	if(currentReadFrage == null)
    	{
    			return;
    	}
    	else {boolean exit = false;
    	while (!exit) {
    		System.out.println(currentReadFrage);

    		if (klicker.hasNextInt()) {
    			int antwort = klicker.nextInt();
    			Antwort Entscheidung = findMatchingAntwort(currentReadFrage.getAntworten(), antwort, null);
    			if(Entscheidung == null)
    			{
    				continue;
    			}
    			else {currentReadFrage = Entscheidung.getFrage();}

    			} else {
    			// keine Zahl
    			exit = true;
    		}

    		// in welchen Fällen muss exit= true gesetzt
    		if (currentReadFrage == null) {
    			// antwort gefunden aber ohne FolgeFrage
    			exit = true;
    		}

    		if (currentReadFrage.getRawAntwort_ID().isBlank()) {
    			// antwort gefunden mit FolgeFrage, die aber keine Antworten besitzt
    			System.out.println(currentReadFrage);
    			exit = true;
    		}
    	}

    	klicker.close();

    	};
    }







	public static Frage init()
	{

			List<Frage> alleFragen = new ArrayList<>();
	        List<Antwort> alleAntworten = new ArrayList<>();

	        Frage ersteFrage = new Frage();
			return ersteFrage;



	    	String line = " ";
	        final String delimiter = ";";

	        try
	        {
	            String fragen_csv = "C:/dev/workspaces/Lotto_daten_lesen/src/de/gds/Lotto_daten_lesen/fragen.csv";
	            FileReader fragen_reader = new FileReader(fragen_csv);

	            String antworten_csv = "C:/dev/workspaces/Lotto_daten_lesen/src/de/gds/Lotto_daten_lesen/antworten.csv";
	            FileReader antworten_reader = new FileReader(antworten_csv);



	            BufferedReader f_reader = new BufferedReader(fragen_reader);
	            while ((line = f_reader.readLine()) != null)   // läuft so lange weiter bis keine Daten mehr vorhanden sind
	            {
	               String[] token = line.split(delimiter);    // Trennzeichenerkennung Semicolon
	               System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+" | "+ token[3]);  // token[0] = ID , token[1] = Sorte, ...

	               Frage currentReadFrage = new Frage();
	               currentReadFrage.setFrage_id(Integer.parseInt(token[0]));
	               currentReadFrage.setFrage_text(token[2] );
	               currentReadFrage.setRawAntwort_ID(token[3]);
	               alleFragen.add(currentReadFrage);
	            }

	            BufferedReader a_reader = new BufferedReader(antworten_reader);
	            while ((line = a_reader.readLine()) != null)   // läuft so lange weiter bis keine Daten mehr vorhanden sind
	            {
	               String[] token = line.split(delimiter);    // Trennzeichenerkennung Semicolon
	               System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+" | "+ token[3]);  // token[0] = ID , token[1] = Sorte, ...

	               Antwort currentReadAntwort = new Antwort(-1, "", null);
	               currentReadAntwort.setAntwort_id(Integer.parseInt(token[0]));
	               currentReadAntwort.setFrage_text(token[2]);
	               currentReadAntwort.setRawFrage_ID(token[3]);
	               alleAntworten.add(currentReadAntwort);
	            }

	        	}


	        catch (IOException e)
	        {
	            e.printStackTrace();

	        }

		}


	private static Antwort findMatchingAntwort(ArrayList<Antwort> antworten, int antwort, ArrayList<Frage> fragen) {
	for (Antwort aktuelleAntwort : antworten)
	{
		for (Frage aktuelleFrage : fragen)
		{

			if (aktuelleAntwort.getRawFrage_ID() == aktuelleFrage.getRawAntwort_ID())
			//	if (Antwort.getAntwort_id(Integer.parseInt(token[0]) == aktuelleFrage.getRawAntwort_ID()))
			{
				return aktuelleAntwort;
			}
		}
			}
	return null;
}



}





























