package de.tictactoesimulation;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Tic Tac Toe startet...");

		// Spieler anlegen
		IPlayer player1 = new Player(1);
		IPlayer player2 = new Player(2);

		// Spielfeld anlegen
		ISpielfeld spielfeld = new Spielfeld();
		IController controller = new Controller(spielfeld);


		// Spieler anmelden
		controller.spielerAnmelden(player1);
		controller.spielerAnmelden(player2);
		// Spieler 1 beginnt
		controller.setPlayerActive(player1);
		
		System.out.println("Lasst uns die Spiele beginnen!");
		
		// Spielen bis jemand gewinnt!
		while(!controller.spielerGewonnen(player1) && !controller.spielerGewonnen(player2)) {
			controller.spielZugAbfragen();
			controller.spielFeldAnzeigen();
		}
		
		if(controller.spielerGewonnen(player1)) {
			System.out.println("\nSpieler 1 hat gewonnen");
		} else if (controller.spielerGewonnen(player2)) {
			System.out.println("\nSpieler 2 hat gewonnen");
		}
		
	}
}