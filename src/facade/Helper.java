package facade;

import java.util.Scanner;

public class Helper {

	Scanner scan = new Scanner(System.in);
	
	public void clearScreen() {
		for (int i = 0; i < 33 ; i++) {
			System.out.println();
		}
	}
	
	public void pressToContinue() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

}
