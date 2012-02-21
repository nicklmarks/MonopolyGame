//Card class used in MonopolyGame to represent the chance cards 
public class Card
{
	private String description;
	private boolean moveType;
	private boolean payType;
	private int payAmount;
	private int moveindex;

	//Constructor for Card( description of card, deals with moving player, 
	// card deals with money, amount to pay or get paid, where to move on the board)
	public Card(String description, boolean moveType, boolean payType, int payAmount, int moveindex)
	{
		this.description = description;
		this.moveType = moveType;
		this.payType = payType;
		this.payAmount = payAmount;
		this.moveindex = moveindex;
	}

	//returns descrition of this Card.
	public String getDescription()
	{
		return description;
	}

	//returns true if the card will move the player, false if not.
	public boolean getMoveType()
	{
		return moveType;
	}

	//returns true if the player will have to pay or get paid, false when not dealing with money.
	public boolean getPayType()
	{
		return payType;
	}

	//returns the amount that the player must pay or get paid
	public int getPayAmount()
	{
		return payAmount;
	}

	//returns the index corresponding to a board space that the player will move to.
	public int getMove()
	{
		return moveindex;
	}
}
