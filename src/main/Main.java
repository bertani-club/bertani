package main;

import java.util.Scanner;

import facade.BertaniFacade;

public class Main {

	Scanner scan = new Scanner(System.in);
	BertaniFacade bertaniFacade = BertaniFacade.getInstance();
	
	public Main() {
		int coin = 10000;
		int day = 1;
		int option = -1;
		
		do {
			bertaniFacade.mainMenu(option, coin, day);
		}while(option != 5);
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
