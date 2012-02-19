//Class Dice for the MonopolyGame program. 

public class Dice {
	
//Static method that returns a random number to represent a dice roll with 2 dice. 
	public static int rollDice() {
		int d1 = (int)(Math.random() *6) + 1;
		int d2 = (int)(Math.random() *6) + 1;
		return d1 + d2;
	}
	
//Static method that decribes whether the dice roll results in doubles.
	public static boolean rollDoubles(){
		int d1 = (int)(Math.random() *6) + 1;
		System.out.println("Dice 1 = " + d1);
		int d2 = (int)(Math.random() *6) + 1;
		System.out.println("Dice 2 = " + d2);
		if(d1 == d2){return true;}
		else{return false;}
	}
}
