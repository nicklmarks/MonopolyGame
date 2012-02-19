//Deck class to represent a deck of cards for the MonopolyGame app.
import java.util.ArrayList;

/** deck class for monopoly game, used to initialize an array of cards.
@author G04
@version cs48 W12
*/

public class Deck {

	private ArrayList<Card> cardList = new ArrayList<Card>();

//constructor for Deck initializes the cardList Arraylist to hold all the necessary cards for a MonopolyGame.
	public Deck() {
		Card card0 = new Card("move to go", true, true, 200, 0);
		Card card1 = new Card("move to first RailRoad", true, false, 0, 5);
		Card card2 = new Card("pay 50$", false, true, -50, 0);	
		Card card3 = new Card("earn 100$", false, true, 100, 0);

		cardList.add(0, card0);
		cardList.add(1, card1);
		cardList.add(2, card2);
		cardList.add(3, card3);

	}

// drawCard function returns a random card from the deck. The card contains values that trigger events.
	public Card drawCard() {
		int num = (int)(Math.random() * 4);
		Card yourCard = cardList.get(num);
		return yourCard;
	}
}
