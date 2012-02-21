//Property class which represents the many properties on the game board
public class Property extends Space{
	
	private int price;
	private int rent;
	private boolean mortgage;
	private boolean monopoly;
	private boolean housable;
	private boolean hotel;
	private int numHouses;	
	private Player owner;
	private String color;

	//no-arg constructor all values defaulted
	public Property() {}

	//constructor (name of property, x-coord, y-coord, price to buy property, rent price,
	// housable(if the space can have houses), color used to group monopolies).
	public Property(String name, int x, int y,int price, int rent, boolean housable, String color) 
	{
		super(x,y,name);
		this.price = price;
		this.rent = rent;
		this.housable = housable;
		this.color = color;
		mortgage = false;
		monopoly = false;
		hotel = false;
		numHouses = 0;
		
	}
	
	//accessor method for color
	public String getColor() {return color;}
	
	//accessor method for price
	public int getPrice() {return price;}
	
	//accessor method for rent
	public int getRent() {return rent;}
	
	//setter method for rent 
	public void setRent(int v){
		this.rent = v;
	}

	//setter method for Mortgage to change between true/false
	public void setMortgage(boolean val) {this.mortgage = val;}
	
	//returns boolean value which tells the player which properties are mortgaged
	public boolean getMortgage() {return this.mortgage;}

	//setter method to set the player as owner of the property
	public void setOwner(Player playa) {this.owner = playa;}
	
	//returns the player who owns this property
	public Player getOwner() {return this.owner;}

	//sets the boolean monopoly value which evaluates if the player owns a monopoly
	public void setMonopoly(boolean val) {this.monopoly = val;}
	
	//returns true/false dependent on if the property is part of a monopoly
	public boolean getMonopoly() {return this.monopoly;}
	
	//boolean value which determines if the property can hold houses
	public boolean isHousable() {return housable;}

	//adds one house to the property
	public void addHouse() {this.numHouses++;}
	
	//returns the number of houses on the property
	public int getNumHouses() {return numHouses;}

	//sets a hotel on the property.
	public void setHotel(boolean val) {hotel=val;}
	
	//returns true if hotel is on property, false for no hotel.
	public boolean getHotel() {return hotel;}

}