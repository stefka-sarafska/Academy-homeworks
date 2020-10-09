package swift.desk;

import cards.annotation.CardsAnnotation;

@CardsAnnotation(type = "class", description = "Represents a card object used to play games with.")
public class Card implements Comparable<Card> {
	private CardSuit suit;
	private CardRank rank;

	public Card(CardSuit suit, CardRank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	@Override
	public int compareTo(Card o) {

		return this.suit.compareTo(o.suit);

	}

}
