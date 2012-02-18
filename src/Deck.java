import java.util.ArrayList;

/** deck class for monopoly game, used to initialize an array of cards. Well start with 10-20.
Methods to include should be a constructor, draw card method.
*/

public class Deck {

	private ArrayList<Card> cardList = new ArrayList<Card>();

	public Deck() {
		Space go = new Space(0, 0, "GO");
		Card card0 = new Card("move to go", true, false, 0, go);
		Card card1 = new Card("move to first RailRoad", true, false, 0, new Space(5,0, "RR1"));
		Card card2 = new Card("pay 50$", false, true, -50, go);	
		Card card3 = new Card("earn 100$", false, true, 100, go);

		cardList.add(0, card0);
		cardList.add(1, card1);
		cardList.add(2, card2);
		cardList.add(3, card3);

	}

	public Card drawCard() {
		int num = (int)(Math.random() * 4);
		Card yourCard = cardList.get(num);
		return yourCard;
	}
}