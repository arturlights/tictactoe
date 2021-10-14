package de.tictactoesimulation;

public class Player implements IPlayer {
	private int spielerID;
	
	Player(int id){
		this.spielerID = id;
	}

	@Override
	public int getID() {
		return this.spielerID;
	}
	
	public String toString() {
		return "Spieler " + spielerID;
	}

}
