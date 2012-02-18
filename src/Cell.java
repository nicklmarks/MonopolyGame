public class Cell{

private Player player;
private int turns;

public Cell(Player player){
	this.player = player;
	this.turns = 1;
}

public Player getPlayer(){
	return this.player;
}

public int getTurns(){
	return this.turns;
}

public void incrementTurns(){
	this.turns = turns + 1;
}

}