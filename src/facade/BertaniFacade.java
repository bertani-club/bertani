package facade;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import model.Crop;
import model.User;
import proxy.Connect;
import proxy.Repository;

public class BertaniFacade {

	Scanner scan = new Scanner(System.in);
	Helper helper = Helper.getInstance();
	Repository repo = Repository.getInstance();
	Vector<User> user = new Vector<>();
	Vector<Crop> crop = new Vector<>();
	
	private static BertaniFacade instance;
	
	public static BertaniFacade getInstance() {
		if(instance == null) {
			instance = new BertaniFacade();
		}
		return instance;
	}
	
	int input;
	
	public void login() {
		System.out.println("-----------------");
		System.out.println("| HARVEST - SUN |");
		System.out.println("-----------------");
		System.out.println("");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("");
		System.out.printf("Choose >> ");
		
		input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1:
			loginUI();
			helper.clearScreen();
			break;
		case 2:
			registerUI();
			helper.clearScreen();
			break;
		case 3:
			helper.clearScreen();
			System.out.println("Thank you for playing our games");
			System.out.println("");
			System.out.println("Credits :");
			System.out.println("1. 2440032133 - Jonathan Felim Jhon");
			System.out.println("2. 2440108843 - Rafli Haikhal");
			System.out.println("3. 2440107720 - Randy Wirjadiredja");
			System.out.println("");
			System.out.println("Class : LC01 | Date : January, 2023");
			helper.pressToContinue();
			System.exit(0);
			break;
		}
	}
	
	private void loginUI() {
		String email, password;
		
		while(true) {
			System.out.printf("Email [must contain @gmail.com] : ");
			email = scan.nextLine();
			
			if(email.contains("@gmail.com")) {
				break;
			}
		}
		
		while(true) {
			System.out.printf("Password [min 8 characters] : ");
			password = scan.nextLine();
			
			if(password.length() >= 8) {
				break;
			}
		}
		
		repo.checkUser(email, password);
	}
	
	private void registerUI() {
		String name, email, password;
		int seasonId = 1;
		int money = 5000;
		int day = 1;
		int year = 1;
		
		while(true) {
			System.out.printf("Name [min 5 characters] : ");
			name = scan.nextLine();
			
			if(name.length() >= 5) {
				break;
			}
		}
		
		while(true) {
			System.out.printf("Email [must contain @gmail.com] : ");
			email = scan.nextLine();
			
			if(email.contains("@gmail.com")) {
				break;
			}
		}
		
		while(true) {
			System.out.printf("Password [min 8 characters] : ");
			password = scan.nextLine();
			
			if(password.length() >= 8) {
				break;
			}
		}
		
		repo.addUser(seasonId, name, email, password, money, day, year);
		System.out.println();
		System.out.println("Your account successful registered!");
		helper.pressToContinue();
		helper.clearScreen();
		login();
	}
	
	public void mainMenu(int id, String name, String seasonName, int money, int day, int year) {
		
		System.out.println("-----------------");
		System.out.println("| HARVEST - SUN |");
		System.out.println("-----------------");
		System.out.println("Welcome, " + name);
		System.out.println("");
		System.out.println("Season : " + seasonName);
		System.out.println("Coin : " + money + "G");
		System.out.println("Day : " + day);
		System.out.println("Year : " + year);
		System.out.println("======================");
		System.out.println("1. Buy Seeds");
		System.out.println("2. Plant Seeds");
		System.out.println("3. Sell Crops");
		System.out.println("4. Sleep");
		System.out.println("5. Logout");
		System.out.println("");
		System.out.printf("Choose >> ");
		input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			sellCrops(money, id);
			break;
		case 4:
			
			break;
		case 5:
			System.out.println("Logout successful");
			helper.pressToContinue();
			helper.clearScreen();
			login();
			break;
		}
	}
	
	public void sellCrops(int money, int id) {
		helper.printLine();
        System.out.printf("| %-5s | %-15s | %-15s | %-15s |\n", "No.", "Crop", "Price", "You have");
        helper.printLine();
        for (Crop c : repo.getCrops(crop, id)) {
            System.out.printf("| %-5d | %-15s | %-15d | %-15d |\n", c.getId(), c.getName(), c.getPrice(), c.getQuantity());
        }
        helper.printLine();
        System.out.println();
        
        int cropsId = 0, cropsQuantity = 0, totalSell = 0;
        
        do {
            System.out.print("Number of crops [1-12]: ");
            cropsId = scan.nextInt();
            scan.nextLine();        
            if(cropsId > 12) {
        		System.out.println("Invalid input.\n");
        		continue;
        	}
        	else if(cropsId == 0) {
        		return;
        	}
        }while(cropsId < 0 || cropsId > 12);
        
        for(Crop c : repo.getCrops(crop, id)) {
    		if(cropsId == c.getId()) {
    			do {
					System.out.print("How many: ");
					cropsQuantity = scan.nextInt();
					scan.nextLine();
				} while (cropsQuantity > c.getQuantity());
    			totalSell = cropsQuantity * cropsId;
    			money = money + totalSell;
    			System.out.println("");
    			System.out.println("Your plant have been sold!\n");
    		}
    	}
	}
	
//	private void buySeedsMenu(int coin, int num, int qty, int totalPrice) {
//		System.out.println("No  Seeds     Price  Harvest Time");
//		System.out.println("---------------------------------");
//		System.out.println("1.  Turnip    150G   2  Days");
//		System.out.println("2.  Corn      200G   3  Days");
//		System.out.println("3.  Cabbage   500G   6  Days");
//		System.out.println("4.  Tomato    340G   4  Days");
//		System.out.println("5.  Potato    650G   10 Days");
//		System.out.println("---------------------------------");
//		System.out.println("");
//		System.out.printf("Coins : %dG\n\n", coin);
//		System.out.printf("Input 0 to exit\n\n");
//		
//		do {
//			System.out.print("Number of seeds [1-5]: ");
//			num = scan.nextInt();
//			scan.nextLine();
//			if(num > 5) {
//				System.out.println("No seeds available.\n");
//				continue;
//			}
//			else if(num == 0) {
//				return;
//			}
//			else {
//				break;
//			}
//		}while(true);
//		
//		do {
//			System.out.print("Quantity of selected seeds [1-10]: ");
//			qty = scan.nextInt();
//			scan.nextLine();
//			if(qty == 0) {
//				return;
//			}
//		}while(true);
//	}

}
