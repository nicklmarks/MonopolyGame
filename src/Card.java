//Card class used in MonopolyGame to represent the chance cards 
public class Card
{
	private String description;
	private boolean moveType;
	private boolean payType;
	private int payAmount;
	private int moveindex;
	
	public Card(String description, boolean moveType, boolean payType, int payAmount, int moveindex)
	{
		this.description = description;
		this.moveType = moveType;
		this.payType = payType;
		this.payAmount = payAmount;
		this.moveindex = moveindex;
	}

	public String getDescription()
	{
		return description;
	}

	public boolean getMoveType()
	{
		return moveType;
	}

	public boolean getPayType()
	{
		return payType;
	}

	public int getPayAmount()
	{
		return payAmount;
	}

	public int getMove()
	{
		return moveindex;
	}
}
