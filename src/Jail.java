import java.util.*;

public class Jail {

	public int bail = 50;
	private ArrayList<Cell> jailList = new ArrayList<Cell>();

	public boolean contains(Player p){
		//returns true if the player is currently in a Cell in the jailList
		for(int i = 0;i<jailList.size();i++){
			if(jailList.get(i).getPlayer() == p){return true;}
		}
		return false;
	}
	
	public void incrementTurns(Player p){
		//increments the turns in the player's Cell in the jailList
		for(int i = 0;i<jailList.size();i++){
			if(jailList.get(i).getPlayer() == p){jailList.get(i).incrementTurns();};
		}			
	}
	
	public int getPlayersTurns(Player p){
		//returns the number of turns that the player has been in jail
		for(int i = 0;i<jailList.size();i++){
			if(jailList.get(i).getPlayer() == p){return jailList.get(i).getTurns();}
		}
		return 0;
	}
	
	public void jailPlayer(Player p){
		//adds a Cell containing the player to the jailList
		jailList.add(new Cell(p));
	}
	
	public void freePlayer(Player p){
		//removes the player's Cell from the jailList, freeing the player
		for(int i = 0;i<jailList.size();i++){
			if(jailList.get(i).getPlayer() == p){jailList.remove(i);}
		}
	}
	
}

