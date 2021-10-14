package de.artureisenkrein.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements IController {
	private ISpielfeld spielfeld;
	private List<IPlayer> playerList;
	private IPlayer playerActive;

	Controller(ISpielfeld spielfeld) {
		playerList = new ArrayList<>();
		this.spielfeld = spielfeld;
	}

	public void setPlayerActive(IPlayer player) {
		this.playerActive = player;
	}
	
	public boolean spielerGewonnen(IPlayer player) {
		boolean spielerGewonnen = false;
		
		// Zeilen
				for (int i = 0; i < spielfeld.getSpielfeld().length; i++) {
					int zaehlerZeile = 0;
					int zaehlerSpalte = 0;
					for (int j = 0; j < spielfeld.getSpielfeld().length; j++) {
						if (spielfeld.getSpielfeld()[i][j] == player.getID()) {
							zaehlerZeile++;
						}
						if (spielfeld.getSpielfeld()[j][i] == player.getID()) {
							zaehlerSpalte++;
						}
					}
					if (zaehlerZeile == 3 || zaehlerSpalte == 3) {
						spielerGewonnen = true;
					}
				}
				// Quer

				if (!spielerGewonnen) {
					spielerGewonnen = this.querPruefen(player);
				}
		
		
		return spielerGewonnen;
	}


	private boolean querPruefen(IPlayer player) {
		boolean rueckgabe = false;

		if (spielfeld.getSpielfeld()[0][0] == player.getID() && spielfeld.getSpielfeld()[1][1] == player.getID()
				&& spielfeld.getSpielfeld()[2][2] == player.getID()) {
			rueckgabe = true;
		}

		if (spielfeld.getSpielfeld()[0][2] == player.getID() && spielfeld.getSpielfeld()[1][1] == player.getID()
				&& spielfeld.getSpielfeld()[2][0] == player.getID()) {
			rueckgabe = true;
		}

		return rueckgabe;
	}

	@Override
	public void spielFeldAnzeigen() {
		for (int i = 0; i < spielfeld.getSpielfeld().length; i++) {
			System.out.println();
			for (int j = 0; j < spielfeld.getSpielfeld()[i].length; j++) {
				if(spielfeld.getSpielfeld()[i][j] == 1) {
					System.out.print("x");
				} else if(spielfeld.getSpielfeld()[i][j] == 2) {
					System.out.print("o");
				} else {
					System.out.print("-");
				}
			}
		}
		System.out.println("\n");
	}


	@Override
	public void spielerAnmelden(IPlayer player) {
		if (playerList.size() < 2) {
			playerList.add(player);
		} else {
			System.out.println("Spieleranzahl fehlerhaft");
		}
	}

	public void spielZugSetzen(int x, int y, IPlayer player) {
		spielfeld.getSpielfeld()[x][y] = player.getID();
	}

	private boolean wertKorrekt(int wert) {
		return wert >= 0 && wert <= 2;
	}
	
	
	public int wertAbfragen() {
		Scanner eingabeWert = new Scanner(System.in);
		int rueckgabe = -1;
		while(!wertKorrekt(rueckgabe)) {
		System.out.println("\n" + playerActive.toString() + " Bitte geben Sie ihren Spielzug ein. Zwischen 0 und 2.");
			rueckgabe = eingabeWert.nextInt();
		}
		return rueckgabe;
	}
	
	
	private void switchActivePlayer() {
		if (playerActive == playerList.get(0)) {
			playerActive = playerList.get(1);
		} else {
			playerActive = playerList.get(0);
		}
	}
	
	@Override
	public void spielZugAbfragen() {
		boolean abfragekorrekt = false;

		while (!abfragekorrekt) {
			int eingabeX = wertAbfragen();
			int eingabeY = wertAbfragen();
			
			if (spielfeld.getSpielfeld()[eingabeX][eingabeY] != 0) {
				System.out.println("Spielfeld bereits belegt");
			} else {
				this.spielZugSetzen(eingabeX, eingabeY, playerActive);
				abfragekorrekt = true;
			}
		}

		// Aktiven Spieler wechseln
		switchActivePlayer();
	}
}