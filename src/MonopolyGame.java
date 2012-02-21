import java.util.*;

public class MonopolyGame{

	//instance variables are public becauses they are all references which have getter and setter methods of their own.
	public ArrayList<Player> playerList = new ArrayList<Player>();
	public Board board = new Board();
	public Input io = new Input();
	public Jail jail = new Jail();
	public Deck deck = new Deck();

	//rolls the dice and moves the player that many spaces. gives him 200 if he passes go.
	public void move(Player playa){
		
		int currentIndex = board.spaceList.indexOf(playa.getLocation()); //index of player
		int roll = Dice.rollDice();     //player's roll
		System.out.println("You've rolled a " + roll);
		int boardSize = board.spaceList.size()-1; // size of board staring at 0
		Space newLocation;
		if (roll > (boardSize-currentIndex)){
			 newLocation = board.spaceList.get(roll-(boardSize-currentIndex));
			 System.out.println("You get 200 dollars for passing go!");
			 playa.addMoney(200);
			 
		}
		else{
			 newLocation = board.spaceList.get(roll + currentIndex);
		}
		playa.setLocation(newLocation);

	}
		
	
	//interacts with the jail object, find out how many turns the player has been in jail and attempts to roll doubles on his behalf, or forces him to pay bail
	//returns true if he player remains in jail
	public boolean dealWithJail(Player currentPlayer){
				//if it is his first or second turn
				if(jail.getPlayersTurns(currentPlayer) < 3){
					System.out.println("This is turn number " + jail.getPlayersTurns(currentPlayer) + " behind bars, you must try and roll doubles:");
					boolean dubs = Dice.rollDoubles();
					//if he gets doubles he is freed
					if(dubs == true){
						jail.freePlayer(currentPlayer); 
						System.out.println("You rolled doubles! You're free!");
						return false;//control passes down to the while loop
					}
					//if he doesnt get doubles, he stays in jail and his number of turns in jail is incremented
					else{
						System.out.println("You failed to roll doubles! you will remain in JAIL!");
						jail.incrementTurns(currentPlayer);
						return true;//make control skip the while loop
					}
				}
				//if it is his third turn
				else{
					System.out.println("This is turn number " + jail.getPlayersTurns(currentPlayer) + " if you fail to roll doubles, you must pay bail:");
					boolean dubs = Dice.rollDoubles();
					//if he gets doubles he is freed
					if(dubs == true){
						jail.freePlayer(currentPlayer);
						System.out.println("You rolled doubles! You're free!");
						return false;//control passes down the the while loop
					}
					//if he doesnt get doubles he must pay bail
					else{
						System.out.println("You failed to roll doubles! You must pay 50 dollars to free yourself");
						currentPlayer.addMoney(-50);
						jail.freePlayer(currentPlayer);
						return false;//control passes down to the while loop
					}
				}	
	}
	
	//gets input from the use as to the number of players and each players name, initializes the playerList
	public void initializePlayers(){
		
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
	
	//checks if the player is bankrupt, if so removes him from the game
	//returns the index of the player who's turn it is next
	public int checkBankrupt(Player p, int nextPlayerIndex){
		if (p.getBankrupt() == true){ 
		playerList.remove(p);
		return nextPlayerIndex - 1;
		}
		else{return nextPlayerIndex;}
	}

}
		