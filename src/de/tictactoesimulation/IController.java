package de.tictactoesimulation;

public interface IController {
	boolean spielerGewonnen(IPlayer player);

	void spielFeldAnzeigen();

	void spielerAnmelden(IPlayer player);
	
	void spielZugSetzen(int x, int y, IPlayer player);
	
	void spielZugAbfragen();
	
	void setPlayerActive(IPlayer player);
}
