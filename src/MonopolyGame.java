import java.util.*;

public class MonopolyGame{

	//instance variables
	public ArrayList<Player> playerList = new ArrayList<Player>();
	public Board board = new Board();
	public Input io = new Input();
	public Jail jail = new Jail();
	public Deck deck = new Deck();

	//methods
	
		//moves player
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
		
	
	
	public boolean dealWithJail(Player currentPlayer){
				if(jail.getPlayersTurns(currentPlayer) < 3){//if it is his first or second turn
					System.out.println("This is turn number " + jail.getPlayersTurns(currentPlayer) + " behind bars, you must try and roll doubles:");//tell him it is his 1st or 2nd turn
					boolean dubs = Dice.rollDoubles();//player rolls dice attempting to get doubles
					if(dubs == true){//if he gets doubles, 
						jail.freePlayer(currentPlayer);//he is freed 
						System.out.println("You rolled doubles! You're free!");//tell hims hes freed
						return false;//control passes down to the while loop
					}
					else{//if he doesnt get doubles, he stays in jail
						System.out.println("You failed to roll doubles! you will remain in JAIL!");//tell him he didnt and he is still in jail
						jail.incrementTurns(currentPlayer);//increment his turns
						return true;//make control skip the while loop
					}
				}//close turns < 3 if statement
				else{//if it is his third turn
					System.out.println("This is turn number " + jail.getPlayersTurns(currentPlayer) + " if you fail to roll doubles, you must pay bail:");//tell him it is his 3rd turn in jail
					boolean dubs = Dice.rollDoubles();//player rolls dice attempting to get doubles
					if(dubs == true){//if he gets doubles,
						jail.freePlayer(currentPlayer);//he is freed
						System.out.println("You rolled doubles! You're free!");//tell him he is freed
						return false;//control passes down the the while loop
					}
					else{//if he doesnt get doubles
						System.out.println("You failed to roll doubles! You must pay 50 dollars to free yourself");//tell him he didnt, and he must pay bail
						currentPlayer.addMoney(-50);//he pays bail
						jail.freePlayer(currentPlayer);//he is freed
						return false;//control passes down to the while loop
					}
				}//close else statement		
	}
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
		