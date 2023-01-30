package facade;

import java.util.Scanner;

public class Helper {

	Scanner scan = new Scanner(System.in);
	
	private static Helper instance;
	
	public static Helper getInstance() {
		if(instance == null) {
			instance = new Helper();
		}
		return instance;
	}
	
	public void clearScreen() {
		for (int i = 0; i < 45 ; i++) {
			System.out.println("");
		}
	}
	
	public void pressToContinue() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public void printLine() {
        for(int i=0; i<63; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
