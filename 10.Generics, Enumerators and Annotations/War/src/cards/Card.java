package cards;

public class Card {
	private String suit;
	private String rank;

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String getRankOfCard() {
		return rank;
	}

	public String getSuitOfCard() {
		return suit;
	}

	@Override
	public String toString() {
		return rank+suit;
	}
	

}
