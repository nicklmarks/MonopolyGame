public class Piece
{
	Space location;
	String color;
	
	public Piece(){}

	public Piece(Space location, String color)
	{
		this.location = location;
		this.color = color;
	}

	public Space getLocation()
	{
		return location;
	}

	public void setLocation(Space s)
	{
		location = s;
	}
}
