package de.gds.lottoobj;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;




/* To Do
 * ------------------------------------------------------------------
 *  - Nullexeption umgehung
 *  1
 *  			Try Catch
 *
 *  			oder
 *
 *  			(Input input)
 *  			{
    			if (input == null) throw new NullPointerException("input");
    			}

 *  - Schleife schließen mit Ende
 *
 *  			break;
 *
 *  			bzw loop für die komme später version
 *
 *  - Doppel Ende anpassen
 *
 *	  Als frage Speichern ohne Antwort   Frage 9 / Frage 10
 * ------------------------------------------------------------------
 */

public class Main {

	// Hauptprogramm //
	//---------------//

	public static void main(String[] args) {

		Frage ersteFrage = init();

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

			if (currentFrage.getAntworten().isEmpty()) {
				// antwort gefunden mit FolgeFrage, die aber keine Antworten besitzt
				System.out.println(currentFrage);
				exit = true;
			}
		}

		in.close();

		};



		/*boolean exit = false;
		while (!exit) {
			System.out.println(currentFrage);

			if (in.hasNextInt()) {
				int antwort = in.nextInt();
				Antwort a = findMatchingAntwort(currentFrage.getAntworten(), antwort);

				currentFrage = a.getFolgeFrage();
			} else {
				// keine Zahl
				exit = true;
			}

			// in welchen Fällen muss exit= true gesetzt
			if (currentFrage == null) {
				// antwort gefunden aber ohne FolgeFrage
				exit = true;
			}

			if (currentFrage.getAntworten().isEmpty()) {
				// antwort gefunden mit FolgeFrage, die aber keine Antworten besitzt
				System.out.println(currentFrage);
				exit = true;
			}
		}

		in.close();*/

	}

	// Listen Abgleich Scanner eingabe mit Nummer aus Liste //
	//------------------------------------------------------//

	public static Antwort findMatchingAntwort(ArrayList<Antwort> allAntworten, int choice) {
		for (Antwort a : allAntworten) {
			if (a.getNummer() == choice) {

				return a;
			}

		}
		return null;
	}

	// Frage Antwort Katalog //
	// ----------------------//

	private static Frage init()
	{
		Frage frage1 = new Frage();
		frage1.setText("Herzlich willkommen! Wie kann ich Ihnen helfen? Möchten Sie Lose für die süddeutsche Klassenlotterie kaufen?");


			Antwort antwort1 = new Antwort();
			antwort1.setText("Ja, ich möchte gerne ein paar Lose kaufen.");
			antwort1.setNummer(1);

			Antwort antwort2 = new Antwort();
			antwort2.setText("Ja, aber ich habe Bedenken wegen meines Spielverhaltens.");
			antwort2.setNummer(2);

			Antwort antwort3 = new Antwort();
			antwort3.setText( "-Du gehst wieder, ohne ein Wort zu sagen!-");
			antwort3.setNummer(3);

			frage1.addAntwort(antwort1);
			frage1.addAntwort(antwort2);
			frage1.addAntwort(antwort3);



		Frage frage2 = new Frage();
		frage2.setText("Gut, ich kann Ihnen dabei helfen. Bevor wir starten, möchten Sie vielleicht ein Limit für Ihr Spiel setzen? Es ist wichtig, verantwortungsbewusst zu spielen.");


			Antwort antwort4 = new Antwort();
			antwort4.setText("Nein, danke. Ich denke, ich kann es im Griff behalten.");
			antwort4.setNummer(4);

			frage2.addAntwort(antwort4);


		Frage frage3 = new Frage();
		frage3.setText("Ich danke Ihnen für Ihre Offenheit. Es ist gut, dass Sie das ansprechen. Ihre Gesundheit und Ihr Wohlbefinden sind uns wichtig. \n"
				+       "Vielleicht ist es eine gute Idee, über eine angemessene Spielgrenze nachzudenken.");

			Antwort antwort5 = new Antwort();
			antwort5.setText("Ja, ich denke, das wäre eine vernünftige Maßnahme. Aber ich möchte dennoch ein paar Lose kaufen. \n"
				+        "Gibt es Möglichkeiten, wie Sie mich dabei unterstützen können?");
			antwort5.setNummer(5);


			Antwort antwort6 = new Antwort();
			antwort6.setText("Eigentlich wollte ich nur ein paar Informationen, ich gehe lieber ohne Lose.");
			antwort6.setNummer(6);

			frage3.addAntwort(antwort5);
			frage3.addAntwort(antwort6);

		antwort1.addFolgeFrage(frage2);
		antwort2.addFolgeFrage(frage3);
		antwort3.addFolgeFrage(frage3);



		Frage frage4 = new Frage();
		frage4.setText("Das ist in Ordnung, aber denken Sie daran, dass es immer gut ist, ein Limit zu setzen, um kontrolliert zu spielen. \n"
				+       "Wenn Sie Fragen haben, stehe ich Ihnen gerne zur Verfügung.");

		antwort4.addFolgeFrage(frage4);


			Antwort antwort7 = new Antwort();
			antwort7.setText("- Du nickst zustimmend und kaufst deine Lose ohne ein Limit -");
			antwort7.setNummer(7);

			Antwort antwort8 = new Antwort();
			antwort8.setText("- Du entscheidest dich nur eine begrenzte Anzahl an Losen zu kaufen, jedoch ohne ein Limit -");
			antwort8.setNummer(8);


			frage4.addAntwort(antwort7);
			frage4.addAntwort(antwort8);


		Frage frage5 = new Frage();
		frage5.setText("Natürlich. Wir werden Ihr Spielkonto so einrichten, dass Sie nur bis zu dem von Ihnen gewünschten Betrag und für die von Ihnen festgelegte \n"
				+       "Zeitspanne Lose kaufen können. Auf diese Weise können Sie sicherstellen, dass Sie verantwortungsbewusst spielen.");

		antwort5.addFolgeFrage(frage5);

			Antwort antwort9 = new Antwort();
			antwort9.setText("Ja, das klingt sinnvoll. Bitte helfen Sie mir dabei, ein Limit festzulegen.");
			antwort9.setNummer(9);

			Antwort antwort10 = new Antwort();
			antwort10.setText("Eigentlich möchte ich es mir nochmal überlegen. Ich komme später darauf zurück.");
			antwort10.setNummer(10);


			frage5.addAntwort(antwort9);
			frage5.addAntwort(antwort10);


		Frage frage6 = new Frage();
		frage6.setText("Natürlich. Wir haben verschiedene Optionen, um Ihnen dabei zu helfen, kontrolliert \r"
				+       "zu spielen. Eine Möglichkeit wäre, eine zeitliche und finanzielle Grenze für Ihr Spielen festzulegen.");

		antwort9.addFolgeFrage(frage6);


			Antwort antwort11 = new Antwort();
			antwort11.setText("Ja, das ist eine gute Idee. Bitte helfe mir, ein wöchentliches Limit festzulegen.");
			antwort11.setNummer(11);

			Antwort antwort12 = new Antwort();
			antwort12.setText("Vielleicht ist es besser, wenn ich heute keine Lose kaufe. Ich werde das zuerst mit \r"
					+	    "meinen Freunden besprechen.");
			antwort12.setNummer(12);

			frage6.addAntwort(antwort11);
			frage6.addAntwort(antwort12);



		Frage frage7 = new Frage();
		frage7.setText("Schade, dass Sie gehen möchten. Falls Sie es sich anders überlegen, sind wir hier, um Ihnen zu helfen. Haben Sie einen schönen Tag!");

		antwort12.addFolgeFrage(frage7);

		Frage frage8 = new Frage();
		frage8.setText("Verstehen wir. Es ist wichtig, dass Sie sich wohl dabei fühlen. \n"
				+       "Wenn Sie später Fragen haben oder Unterstützung benötigen, können Sie sich gerne an uns wenden.");
		frage8.addAntwort(antwort5);
		frage8.addAntwort(antwort6);


		Frage frage9 = new Frage();
		frage9.setText(" - Du bedankst dich und verlässt das Geschäft! -");

		antwort10.addFolgeFrage(frage9);
		antwort12.addFolgeFrage(frage9);


		Frage frage10 = new Frage();
		frage10.setText(" - Du bedankst dich beim Verkäufer/in und verlässt mit deinen gekauften Losen das Geschäft");

		antwort7.addFolgeFrage(frage10);
		antwort8.addFolgeFrage(frage10);

		return frage1;

	}
}




/*    Input    - Nacharbeitung
 -----------------------------------------------------

 // längere Variante für Ausgabe - toString nur bedingt sinnvoll idm Fällen !!

		/*
		 * System.out.println(ersteFrage.getText()); ArrayList<Antwort>
		 * allPossibleAntworten = ersteFrage.getAllPossibleAntworten();
		 *
		 * for (Antwort antwort : allPossibleAntworten) {
		 * System.out.println(antwort.getNummer()+ " - " +antwort.getText()); }



 for each umgehung zum besseren Verständnis

 // for(Iterator<String> i = someList.iterator(); i.hasNext(); ) {
	// String item = i.next();
	// System.out.println(item);

	/*
	 * for (People person : peopleList) { if (person.getName().equals(name) &&
	 * person.getPostcode().equals(postCode)) result.add(person.getId()); }
	 *
	 * if(result.isEmpty()){ return null; }else{ return result; } }
	 *
	 *
	 * Resumee 03.08
	 *
	 * scoping {}
	 * Methoden ihre Attribute
	 *
	 * Naming !!!!!
 -----------------------------------------------------
 */
