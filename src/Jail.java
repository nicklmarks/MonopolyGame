
public class Jail extends Space{

	int bail = 50;
	int[] turns = new int[4];

	public Jail(){}

	public void setTurns(int p, int value) {
		turns[p-1] = value;
	}

	public int getTurns(int p) {return turns[p-1];}

}

