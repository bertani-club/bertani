package main;

import facade.BertaniFacade;

public class Main {

	BertaniFacade bertaniFacade = BertaniFacade.getInstance();

	public Main() {

		while (true) {
			bertaniFacade.login();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
