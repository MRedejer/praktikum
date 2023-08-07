package de.gds.Lotto_daten_lesen;

import java.io.*;
import java.util.Scanner;

import de.gds.Lotto_daten_lesen.Antwort;
import de.gds.Lotto_daten_lesen.Frage;

/*   To Do
 *  --------------------------------------------------
 *
 * Eclipse
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * 1.  Daten einlesen u an die jeweilige Klasse ausgeben.
 * 2.  Daten zueinander zuordnen ohne zuviel Chaos zu machen.
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
    public static void main(String[] args) throws FileNotFoundException {

      		Object filepath;
			Frage ersteFrage = FileReader.nullReader(filepath);
    		Scanner in = new Scanner(System.in);

    		Frage currentFrage = ersteFrage;

    		if(currentFrage == null)
    		{
    				return;
    		}
    		else {boolean exit = false;
    		while (!exit) {
    			System.out.println(currentFrage);

    			if (in.hasNextInt()) {
    				int antwort = in.nextInt();
    				Antwort handlung = findMatchingAntwort(currentFrage.getAntworten(), antwort);
    				if(handlung == null)
    				{
    					continue;
    				}
    				else {currentFrage = handlung.getFolgeFrage();}

    				} else {
    				// keine Zahl
    				exit = true;
    			}

    			// in welchen Fällen muss exit= true gesetzt
    			if (currentFrage == null) {
    				// antwort gefunden aber ohne FolgeFrage
    				exit = true;
    			}

    			if (((String) currentFrage.getAntworten()).isEmpty()) {
    				// antwort gefunden mit FolgeFrage, die aber keine Antworten besitzt
    				System.out.println(currentFrage);
    				exit = true;
    			}
    		}

    		in.close();

    		};

    }

	private static Antwort findMatchingAntwort(Object antworten, int antwort) {
		// TODO Auto-generated method stub
		return null;
	}


}







/*
 * #Code Rest Rampe #
 * ##################
 *
 * String line = "";
        final String delimiter = ";";
        try
        {
            String filePath = "C:/dev/workspaces/Lotto_daten_lesen/src/de/gds/Lotto_daten_lesen/antworten.csv";
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   // läuft so lange weiter bis keine Daten mehr vorhanden sind
            {
               String[] token = line.split(delimiter);    // Trennzeichenerkennung Semicolon
             System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);  // token[0] = ID , token[1] = Sorte, ...
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 *
 * ##################
 *
 * */
