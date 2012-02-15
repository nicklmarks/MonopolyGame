public class GameRunner{

	public static void main(String [] args){
		MonopolyGame mg = new MonopolyGame(); //create a new Monopoly Game
		mg.initializePlayers(); //get Number of players from user, and initialize the playerList with all player names
		boolean gameContinues = true;
		String answer; //initializes String to hold user input
		Player currentPlayer = mg.playerList.get(0); //sets the current Player reference to the first player in the playerList array
		int nextPlayerIndex = 1; //keeps track of the next player's index in the playerList ArrayList
		
		while(gameContinues){
			System.out.println("-------------------------------------------");
			currentPlayer.playerReadout();//prints out player name, money, etc. to start turn
			
			//??what to do here if player is in jail??
			
				while(true){//continue forever until player rolls the dice, 
				
					System.out.println("You may type 'roll', 'buy' (to buy houses/hotels), or 'mortgage'");//tells player he has options to roll, mortgage, buy houses
					answer = mg.io.getInput(); //gets user answer and stores it in String answer
					
					if(answer.equals("roll") || answer.equals("Roll")){ 
						//Player.move(); //method need to be written
						currentPlayer.spaceAction(mg.io); //does whatever is required, finishes turn
						nextPlayerIndex = mg.checkBankrupt(currentPlayer,nextPlayerIndex);//checks if player has gone bankrupt, change the nextPlayerIndex if a player is removed
						break;//player's turn is over, so exit while loop
					}
					
					else if(answer.equals("mortgage")){}
					
					else if(answer.equals("buy")){}
					
					else{System.out.println("Error: incorrect input. please input 'roll','buy',or 'mortgage'");}
				}//close inner while loop
				
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
		Create a new Game (Initializes the board, dice, playerlist, input class)
		User inputs the number of Players-->Game creates correct number of Player objects and puts them into ArrayList playerlist
		User inputs each of the Player's names-->Game iterates through playerlist and sets each Player's name
		
		
		
		While(More than one player is not bankrupt){
			first print out players name, location, money, and number of properties
			Taketurn{
			
			if(player is in jail){
				????
			}
			
			else{
				while(player has not rolled){
				
					tell player he has option to roll, buy houses/hotels, or mortgage properties, (turn ends once player rolls)
					get user input and compare it to these three cases:
					A. if(buy houses/hotels){
						while(answer=yes){
							display list of owned properties that are in monopolies, what color they properties are, and the current number of houses/hotels on each propery
							user types in a property name to select it
							program asks how many houses to add(if the property already has 4 houses, ask if they would like to add a hotel)
							user inputs number of houses
							houses/hotels are added, rent for the property is updated, player pays amount
							ask if player would like to continue buying houses{
								if user answers no then set answer to no and exit inner while loop
							}
						}
					}
					
					B. if(mortgage properties){
						while(answer==yes){
							display list of owned properties, their houses/hotels, and their mortgage value
							user types in property name to select it
							property mortgage status is set to true
							player recieves correct amount of money
							ask if player would like to mortgage another property{
								if user answers no then set answer to no and exit inner while loop
							}	
						}
					}
				
					C. if(roll){
						roll the dice
						print out the dice roll
						move the players piece
						call Player.spaceAction method? (this should do whatever is required like paying rent, giving the option to buy, charging tax, giving 200$ for passing go)
						end turn (set a boolean value so that the outer while loop closes)
					}
				
				}//close inner while loop
				
			}//close else
			
		}//close taketurn
		
		Check if game is over (More than one player is not bankrupt)
		Move to next player
		}//close outer while loop
		Declare Winner
		*/

	