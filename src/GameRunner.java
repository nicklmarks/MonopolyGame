public class GameRunner{

	public static void main(String [] args){
		MonopolyGame mg = new MonopolyGame(); //create a new Monopoly Game
		mg.initializePlayers(); //get Number of players from user, and initialize the playerList with all player names
		boolean gameContinues = true;
		String answer; //initializes String to hold user input
		Player currentPlayer = mg.playerList.get(0); //sets the current Player reference to the first player in the playerList array
		int nextPlayerIndex = 1; //keeps track of the next player's index in the playerList ArrayList
		boolean skip = false; //initializes a boolean variable that will be used to skip the players turn if he remains in jail
		
		while(gameContinues){//players turn will continue forever until he rolls, which will break out the while loop
			System.out.println("-------------------------------------------");//line break between different players turns
			
			//what to do here if player is in jail:
			if(mg.jail.contains(currentPlayer)){//if player is in jail:
				System.out.println("Player " + currentPlayer.getName() + " : you are locked up in JAIL!");//print out you are locked in jail
				skip = mg.dealWithJail(currentPlayer);;
			}//close jail if statement
			
			if(skip == false){//skip this part if the player remains in jail
				currentPlayer.playerReadout();//prints out player name, money, etc. to start turn
				while(true){//continue forever until player rolls the dice, 
				
					System.out.println("You may type 'roll', 'buy' (to buy houses/hotels), or 'mortgage'");//tells player he has options to roll, mortgage, buy houses
					answer = mg.io.getInput(); //gets user answer and stores it in String answer
					
					if(answer.equals("roll") || answer.equals("Roll")){ 
						mg.move(currentPlayer); //moves currentPlayer
						currentPlayer.spaceAction(mg); //does whatever is required when the player lands on a space
						nextPlayerIndex = mg.checkBankrupt(currentPlayer,nextPlayerIndex);//checks if player has gone bankrupt, change the nextPlayerIndex if the player has and is removed
						break;//player's turn is over, so exit while loop
					}
					
					else if(answer.equals("mortgage")){}
					
					else if(answer.equals("buy")){}
					
					else{System.out.println("Error: incorrect input. please input 'roll','buy',or 'mortgage'");}
				}//close inner while loop
			}//close if statement
			
			if(mg.playerList.size() == 1){gameContinues = false;}//check if game has a winner
			else{//if no winner yet then switch to next players turn
					if(nextPlayerIndex >= mg.playerList.size()){nextPlayerIndex = 0;} //if we are on the last player in the playerList, set nextPlayerIndex to the first Player (0)
					currentPlayer = mg.playerList.get(nextPlayerIndex); //move to next player
					nextPlayerIndex++; //increment nextPlayerIndex
			}
			
		}//close outer while
		
		System.out.println("Congratulations " + mg.playerList.get(0).getName() + "! You Won the Game!");//pronounce winner
	}	
}		
		/**
					A. if(buy houses/hotels){
						while(answer=yes){
							display list of owned properties that are in monopolys, what color they properties are, and the current number of houses/hotels on each propery
							user types in a property name to select it
							program asks how many houses to add(if the property already has 4 houses, ask if they would like to add a hotel)
							user inputs number of houses
							houses/hotels are added, rent for the property is updated, player pays amount
							ask if player would like to continue buying houses{
								if user answers no then set answer to no and exit inner while loop

					B. if(mortgage properties){
						while(answer==yes){
							display list of owned properties, their houses/hotels, and their mortgage value
							user types in property name to select it
							property mortgage status is set to true
							player recieves correct amount of money
							ask if player would like to mortgage another property{
								if user answers no then set answer to no and exit inner while loop
	*/