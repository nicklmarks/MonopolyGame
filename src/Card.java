public class Card
{
	String description;
	boolean moveType;
	boolean payType;
	int payAmount;
	Space move;
	
	public Card(String description, boolean moveType, boolean payType, int payAmount, Space move)
	{
		this.description = description;
		this.moveType = moveType;
		this.payType = payType;
		this.payAmount = payAmount;
		this.move = move;
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

	public Space getMove()
	{
		return move;
	}
}
