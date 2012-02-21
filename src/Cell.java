public class Cell{

private Player player;
private int turns;

public Cell(Player player){
//constructor: creates a cell containing the player and sets his turns in jail to 1
	this.player = player;
	this.turns = 1;
}

public Player getPlayer(){
//returns the cell's player
	return this.player;
}

public int getTurns(){
//returns the cell's player's number of turns in jail
	return this.turns;
}

public void incrementTurns(){
//increments the cell's player's number of turns in jail
	this.turns = turns + 1;
}

}