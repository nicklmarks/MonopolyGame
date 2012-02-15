import java.util.*;

public class MonopolyGame{

	//instance variables
	public ArrayList<Player> playerList = new ArrayList<Player>();
	public Board board = new Board();
	public Input io = new Input();

	//methods
	public void initializePlayers(){
		//gets input from the use as to the number of players and each players name, initializes the playerList
		System.out.println("Input the number of players (2-4):");
		try{
			int numPlayers = Integer.parseInt(io.getInput());
			if(numPlayers < 2 || numPlayers > 4){throw new Exception();}
			for(int i = 0; i < numPlayers ; i++){
				System.out.println("Input Player" + (i+1) + "'s name");
				playerList.add(new Player(io.getInput(),board.spaceList.get(0),"Green"));//need to resolve issue if two names are the same? also need to change how color is initalized if we implement graphics
			}
		}catch(Exception ex){
			System.out.println("Error: please enter an integer between 2 and 4(e.g. '3', not 'three')");
			this.initializePlayers();
		}
	}
	
	public int checkBankrupt(Player p, int nextPlayerIndex){
		//checks if the player is bankrupt, returns the index of the player who's turn it is next
		if (p.getBankrupt() == true){ 
		playerList.remove(p);
		return nextPlayerIndex - 1;
		}
		else{return nextPlayerIndex;}
	}

}
		