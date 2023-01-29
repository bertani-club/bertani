package facade;

import java.util.Scanner;

public class BertaniFacade {

	Scanner scan = new Scanner(System.in);
	
	private static BertaniFacade instance;
	
	public static BertaniFacade getInstance() {
		if(instance == null) {
			instance = new BertaniFacade();
		}
		return instance;
	}
	
	public void mainMenu(int option, int coin, int day) {
		System.out.println("-----------------");
		System.out.println("| HARVEST - SUN |");
		System.out.println("-----------------");
		System.out.println("");
		System.out.printf("Coins : %dG\n", coin);
		System.out.printf("Day   : %d\n", day);
		System.out.println("");
		System.out.println("1. Buy Seeds");
		System.out.println("2. Plant Seeds");
		System.out.println("3. Sell Crops");
		System.out.println("4. Sleep");
		System.out.println("5. Exit");
		System.out.println("");
		System.out.print("Choose >> ");
		option = scan.nextInt();
		scan.nextLine();
		
		switch (option) {
		case 1:
			int num = 0;
			int qty = 0;
			int totalPrice = 0;
			buySeedsMenu(coin, num, qty, totalPrice);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			exitMessage();
		}
	}
	
	public void buySeedsMenu(int coin, int num, int qty, int totalPrice) {
		System.out.println("No  Seeds     Price  Harvest Time");
		System.out.println("---------------------------------");
		System.out.println("1.  Turnip    150G   2  Days");
		System.out.println("2.  Corn      200G   3  Days");
		System.out.println("3.  Cabbage   500G   6  Days");
		System.out.println("4.  Tomato    340G   4  Days");
		System.out.println("5.  Potato    650G   10 Days");
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.printf("Coins : %dG\n\n", coin);
		System.out.printf("Input 0 to exit\n\n");
		
		do {
			System.out.print("Number of seeds [1-5]: ");
			num = scan.nextInt();
			scan.nextLine();
			if(num > 5) {
				System.out.println("No seeds available.\n");
				continue;
			}
			else if(num == 0) {
				return;
			}
			else {
				break;
			}
		}while(true);
		
		do {
			System.out.print("Quantity of selected seeds [1-10]: ");
			qty = scan.nextInt();
			scan.nextLine();
			if(qty == 0) {
				return;
			}
		}while(true);
	}
	
	public void exitMessage() {
		System.out.println("Thanks for playing!");
		System.out.println("");
		System.out.println("Press any key to exit...");
		scan.nextLine();
		System.exit(1);
	}

}
