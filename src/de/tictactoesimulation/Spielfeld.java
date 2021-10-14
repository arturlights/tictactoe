package de.tictactoesimulation;

import java.util.ArrayList;
import java.util.List;

public class Spielfeld implements ISpielfeld {
	private int[][] spielfeld;

	Spielfeld() {
		// Spielfeld erstellen
		spielfeld = new int[3][3];

		// Spielfeld initialisieren
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[i].length; j++) {
				spielfeld[i][j] = 0;
			}
		}

	}

	public int[][] getSpielfeld() {
		return this.spielfeld;
	}
	
}