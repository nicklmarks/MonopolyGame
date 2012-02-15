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

	public Property() {}

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
	
	public String getColor() {return color;}
	public int getPrice() {return price;}
	public int getRent() {return rent;}
	
	public void setRent(int v){
		this.rent = v;
	}

	public void setMortgage(boolean val) {this.mortgage = val;}
	public boolean getMortgage() {return this.mortgage;}

	public void setOwner(Player playa) {this.owner = playa;}
	public Player getOwner() {return this.owner;}

	public void setMonopoly(boolean val) {this.monopoly = val;}
	public boolean getMonopoly() {return this.monopoly;}

	public boolean isHousable() {return housable;}

	public void addHouse() {this.numHouses++;}
	public int getNumHouses() {return numHouses;}

	public void setHotel(boolean val) {hotel=val;}
	public boolean getHotel() {return hotel;}

}