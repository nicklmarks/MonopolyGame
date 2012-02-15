import java.util.*;

public class Player{

	//instance variables
	
	private int money = 1500;
	private ArrayList<Property> properties = new ArrayList<Property>();
	private String name;
	private Piece piece; //this should set players to the go space
	private boolean gojStatus = false;
	private boolean bankrupt = false;
	
	//methods
	
	public Player(String name, Space s, String c){
		//constructor
		this.name = name;
		this.piece = new Piece(s,c);
	}
	
	public void playerReadout(){
		//to be called upon the start of the players turn, displays player name, location, money and number of properties
		System.out.println("Player " + name + " : you are on " + piece.getLocation().getName());
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
		
	public void spaceAction(Input io){
		Space currentSpace1 = piece.getLocation();
		
		if(currentSpace1 instanceof Property){//Class Type Property:
			Property currentSpace = (Property)currentSpace1;
			if(currentSpace.getOwner() == null){//unowned property
				System.out.println(currentSpace.getName() + " is unowned, would you like to buy it for " + currentSpace.getPrice() +" Dollars? (yes or no)");//ask if user would like to buy the property
				String answer = io.getInput(); //get user answer
				if(answer.equals("yes") || answer.equals("y") || answer.equals("Yes")){//if yes
						try{
							this.buyProperty(currentSpace);//player buys, pays, gets property
							System.out.println("Congratulations! you now own " + currentSpace.getName());//tell him he owns it
							this.checkMonopoly(currentSpace.getColor());//check if the player now owns a monopoly of the input color, if so set monopoly status on all properties in the monopoly,
						}catch(Exception ex){//if he doesnt have enough money
							System.out.println("Sorry, you don't have enough money...");
						}
				}
				else if(answer.equals("no") || answer.equals("n") || answer.equals("No")){}//if no then do nothing
				else{//if user types something else, give him an error message and ask again
				System.out.println("Error: please input either 'yes' or 'no'");
				this.spaceAction(io);
				}
			}
			else if(currentSpace.getOwner() != this){//owned property
				System.out.println(currentSpace.getName() + " is already owned, you owe " + currentSpace.getOwner().getName() + " " + currentSpace.getRent() + " dollars.");//tell user that he landed on a space owned by (playername) and he will be charged $$ rent
				if(money >= currentSpace.getRent()){//if the player has enough money:
					money = money - currentSpace.getRent();//charge the player
					currentSpace.getOwner().addMoney(currentSpace.getRent());//give money to the owner
				}
				else{//if the player doesnt have enough money:
					bankrupt = true;//bankrupt him,
					currentSpace.getOwner().addMoney(this.getMoney());
					System.out.println("You dont have enough money to pay, you are bankrupt, you LOSE!");//inform him he has lost
				}
			}
			else{//else you own the property
				System.out.println("You already own " + currentSpace.getName());
			}
		}
		/**else if(currentSpace1 instanceof Jail){	//Class Type Jail:
			//if just visiting
			
			//if behind bars
		}
		else if(currentSpace1 instanceof Chance){//Class Type Chance:
			
		}	
		else if(currentSpace1 instanceof Tax){//Class Type Tax:
		
		}
		else{//Else (Class Type Space):
		
			//Go to jail
		
			//Go (do nothing)
			
			//Free Parking (do nothing)
		} */
	}
	
	public void checkMonopoly(String c){
		//looks through player's properties list and see if he owns all three properties of a color(String c), if so set each property's monopoly status to true
		int counter = 0;
		for(int i=0; i<properties.size();i++){
			if(properties.get(i).getColor().equals(c)){counter++;}
		}
		if(counter == 3){
			for(int j=0;j<properties.size();j++){
				if(properties.get(j).getColor().equals(c)){properties.get(j).setMonopoly(true);}
			}
			System.out.println("Congrats! You now own a monopoly of " + c);
		}
	}
		
	
	public boolean getBankrupt(){return bankrupt;}
		
	public String getName(){return name;}
			
	public int getMoney(){return money;}
	
	public void addMoney(int value){
		//adds the input amount to the players current total
		money = money + value;
	}
	
	public void buyProperty(Property p) throws Exception{
		if(p.getPrice() > money){throw new Exception();}
		p.setOwner(this);//set owner to the player
		money = money - p.getPrice();//charge the player
		properties.add(p);//add property to player's property list
	}
	
	public void removeProperty(Property p){
		properties.remove(p);
	}
	
	public void movePiece(Space s){
		//moves the players Piece to the input Space
		piece.setLocation(s);
	}
	
	public boolean getgojStatus(){return gojStatus;}
	
	public void setgojStatus(boolean b){
		gojStatus = b;
	}
	
}
	
	
