public class Dice {
	
	public static int rollDice() {
		int d1 = (int)(Math.random() *6) + 1;
		int d2 = (int)(Math.random() *6) + 1;
		return d1 + d2;
	}
	
	public static boolean rollDoubles(){
		int d1 = (int)(Math.random() *6) + 1;
		System.out.println(d1);
		int d2 = (int)(Math.random() *6) + 1;
		System.out.println(d2);
		if(d1 == d2){return true;}
		else{return false;}
	}
}