import java.util.*;

public class Player{

	private int money = 1500;
	private ArrayList<Property> properties = new ArrayList<Property>();
	private String name;
	private boolean gojStatus = false; //get out of jail card status
	private boolean bankrupt = false;
	private Space location;
	private String playercolor;
	
	
	public Player(String name, Space s, String c){
		//constructor
		this.name = name;
		this.location = s;
		this.playercolor = c;
	}
	
	public void playerReadout(){
		//to be called upon the start of the players turn: displays player name, location, money and number of owned properties
		System.out.println("Player " + name + " : you are on " + location.getName());
		System.out.println("You have " + money + " dollars and you own " + properties.size() + " properties:");
	}
	
	public void monopoliesReadout(){
		//displays the players properties that are in monopolies with number of houses/hotels and the current rent
		if(properties.size() > 0){
			for(Property p : properties){
				if(p.getMonopoly() == true){
					if(p.getHotel() == false){
						System.out.println(p.getName() + " (" + p.getNumHouses() + " Houses) : Rent = " + p.getRent());
					}
					else{
						System.out.println(p.getName() + " (Hotel) : Rent = " + p.getRent());
					}
				}
			}
		}
	}
		
	public void spaceAction(MonopolyGame mg){
		//to be called whenver the player lands on a space. communicates with the user and performs whatever actions are required based on the type and status of the space.
		
		Space currentSpace1 = location;
		Board board = mg.board;
		Input io = mg.io;
		Jail jail = mg.jail;
		Deck deck = mg.deck;
		
		//if the space is of type Property:
		if(currentSpace1 instanceof Property){
			Property currentSpace = (Property)currentSpace1;
			//if the property is unowned: asks if the player would like to buy it
			if(currentSpace.getOwner() == null){
				System.out.println(currentSpace.getName() + " is unowned, would you like to buy it for " + currentSpace.getPrice() +" Dollars? (yes or no)");
				String answer = io.getInput();
				//if the player says yes, he pays and recieves the property.
				if(answer.equals("yes") || answer.equals("y") || answer.equals("Yes")){//if yes
						try{
							this.buyProperty(currentSpace); // throws exception if the player doesnt have enough money
							System.out.println("Congratulations! you now own " + currentSpace.getName());
							//check if the player now owns a monopoly of the input color, if so set monopoly status on all properties in the monopoly,
							this.checkMonopoly(currentSpace.getColor());
						}catch(Exception ex){//(if he doesnt have enough money)
							System.out.println("Sorry, you don't have enough money...");
						}
				}
				//if no then do nothing
				else if(answer.equals("no") || answer.equals("n") || answer.equals("No")){}
				//if user types something else, give him an error message and ask again(calls the function recursively to do so)
				else{
				System.out.println("Error: please input either 'yes' or 'no'");
				this.spaceAction(mg);
				}
			}
			//if the property owned by someone else
			else if(currentSpace.getOwner() != this){
				//if the property isnt mortgaged
				if(currentSpace.getMortgage() == false){
					System.out.println(currentSpace.getName() + " is already owned, you owe " + currentSpace.getOwner().getName() + " " + currentSpace.getRent() + " dollars.");//tell user that he landed on a space owned by (playername) and he will be charged $$ rent
					//if the player has enough money:
					if(money >= currentSpace.getRent()){
						money = money - currentSpace.getRent();//charge the player
						currentSpace.getOwner().addMoney(currentSpace.getRent());//give money to the owner
					}
					//if the player doesnt have enough money:
					else{
						bankrupt = true;//bankrupt him,
						currentSpace.getOwner().addMoney(this.getMoney());//give the owner his remaining money
						System.out.println("You dont have enough money to pay, you are bankrupt, you LOSE!");//inform him he has lost
					}
				}
				//other wise the property is mortgaged and the player doesnt have to pay
				else{
					System.out.println(currentSpace.getName() + " is owned by " + currentSpace.getOwner().getName() + " but it is mortgaged, so you don't have to pay");
				}
			}
			//else you own the property
			else{
				System.out.println("You already own " + currentSpace.getName());
			}
		}
		//Else (Class Type Space):
		else{
			//Income Tax
			if(currentSpace1.getName().equals("Income Tax")){
				System.out.println("You've landed on Income Tax, you owe 200 dollars");
				if(money >= 200){ money = money - 200;}//if player has enough money to pay
				else{//if he doesnt, bankrupt him
					bankrupt = true;
					System.out.println("You dont have enough money to pay, you are bankrupt, you LOSE!");
				}	
			}
			//Luxury Tax
			else if(currentSpace1.getName().equals("Luxury Tax")){
				System.out.println("You've landed on Luxury Tax, you owe 75 dollars");
				if(money >= 75){ money = money - 75;}//if player has enough money to pay
				else{//if he doesnt, bankrupt him
					bankrupt = true;
					System.out.println("You dont have enough money to pay, you are bankrupt, you LOSE!");
				}
			}
			//CHANCE
			else if(currentSpace1.getName().equals("CHANCE")){
				System.out.println("You've landed on Chance");
				Card mycard = deck.drawCard();
				System.out.println(" Your Card: " + mycard.getDescription());
				if(mycard.getPayType() == true){this.money = this.money + mycard.getPayAmount();}
				else if(mycard.getMoveType() == true){
					this.location = board.spaceList.get(mycard.getMove());
					this.spaceAction(mg);
				}
			}
			//Go to Jail
			else if(currentSpace1.getName().equals("Go to Jail")){
				System.out.println("You've landed on 'Go to Jail', Your being locked up!");
				location = board.spaceList.get(10);//move the player to the jail space on the board
				jail.jailPlayer(this);//actually put player in Jail
			}
			//Go or Free Parking or Jail(Visiting) --> do nothing
			else{System.out.println("You've landed on " + currentSpace1.getName());}
		} 
	}
	
	public void checkMonopoly(String c){
	//To be called right after the SpaceAction Method
	//looks through player's properties list and see if he owns all three properties of a color(String c), if so set each property's monopoly status to true
		if(c != null){
			int counter = 0;
			for(int i=0; i<properties.size();i++){
				if(properties.get(i).getColor() != null && properties.get(i).getColor().equals(c)){counter++;}
			}
			if(counter == 3){
				for(int j=0;j<properties.size();j++){
					if(properties.get(j).getColor() != null && properties.get(j).getColor().equals(c)){properties.get(j).setMonopoly(true);}
				}
				System.out.println("Congrats! You now own a monopoly of " + c);
			}
		}
	}
		
	//returns the players bankrupt status
	public boolean getBankrupt(){return bankrupt;}
	
	//returns the players name	
	public String getName(){return name;}
			
	//returns the players money		
	public int getMoney(){return money;}
	
	//adds the input amount to the players current total
	public void addMoney(int value){
		money = money + value;
	}
	
	//player purchases the input property
	//throws an exception if the player doesnt have enough money
	public void buyProperty(Property p) throws Exception{
		if(p.getPrice() > money){throw new Exception();}
		p.setOwner(this);
		money = money - p.getPrice();
		properties.add(p);
	}
	
	//removes the property from the players property list
	public void removeProperty(Property p){
		properties.remove(p);
	}
	
	//returns the players get out of jail card status
	public boolean getgojStatus(){return gojStatus;}
	
	//sets the players get out of jail card status
	public void setgojStatus(boolean b){
		gojStatus = b;
	}
	
	//returns the players current location on the board
	public Space getLocation(){return this.location;}
	
	//sets the players current location on the board
	public void setLocation(Space newLocation){this.location = newLocation;}
}
	
	
