//Space class to represent a space on the board extends to properties, chance, and other spaces.
public class Space{

	private String name;
	private int xcoord;
	private int ycoord;

	//no-arg constructor initializes empty string and (0,0) for (x,y) coord
	public Space(){}
	
	//constructor (x-coord, y-coord, name of the space)
	public Space(int x, int y, String name){
		xcoord=x;
		ycoord=y;
		this.name=name;
	}

	//accessor method for name.
	public String getName(){return this.name;}
}




























