package github;

import java.util.Scanner;

public class HängaGubbe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String Ordet = sc.nextLine();
		char[] unknown = new char[Ordet.length()];
		char blank = '_';
		int liv = 10;
		char[] WrongAnswer = new char[liv];
		int WrongInstances = -1;
		int e = 1;

		 //ersätter blanken i arrayen med okända
		for (int i = 0; i <= Ordet.length() - 1; i++) {
			unknown[i] = (char) (blank + ' ');
		}

		// För att gömma ordet
		for (int i = 0; i < 15; i++) {
			System.out.println(" ");
		}

		// Visar det gömda ordets längd
		for (int i = 0; i <= Ordet.length() - 1; i++) {
			System.out.print(blank + " ");
		}
		
		while (liv != 0) {
			char guess = sc.next().charAt(0);
			boolean wrong = true;
			//Fyller i det gömda ordet med rätt gissning
			for (int i = 0; i <= Ordet.length() - 1; i++) {
				if (guess == Ordet.charAt(i)) {
					unknown[i] = guess;
					wrong = false;
				}
			}
			String s = "";
			//Gör char[] arrayen unknown till en string
			for (int i = 0; i < unknown.length; i++) {
				s+= unknown[i];
			}
			System.out.println(s);
			
			//Minskar och skriver ut antalet liv kvar vid fel svar och visar alla felaktiga bokstäver man gissat på
			if (wrong) {
				WrongInstances++;
				liv--;
				WrongAnswer[WrongInstances] = guess;
				System.out.println("Lives left: " + liv);
				System.out.print("Wrong characters: ");
				System.out.println(WrongAnswer);
				
			}
			
			//Avslutar spelet när liv tar slut
			if (liv == 0) {
				System.out.println("Lose");
				System.out.println("The word was: " + Ordet);
				break;
			}
			
			//Avslutar spelet då spelaren har gissat rätt för alla bokstäver
			else if (s.equalsIgnoreCase(Ordet) == true) {
				System.out.println("Win");
				break;
			}
		}
	}

}
