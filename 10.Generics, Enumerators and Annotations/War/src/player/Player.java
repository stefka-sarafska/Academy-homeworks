package player;

import java.util.LinkedList;

import cards.Card;
import cards.CardRank;
import cards.CardSuit;

public class Player {
	private LinkedList<Card> cards;

	public Player(LinkedList<Card> cards) {
		this.cards = cards;
	}

	public LinkedList<Card> getCards() {
		return cards;
	}
	public int getCardListSize() {
		return this.cards.size();
	}

	public Card getCardOfTheTop() {
		return cards.peek();
	}

	public Card removeCardAndGetCard() {
		return cards.poll();
	}

	public void addCard(Card earnedCard) {
		cards.add(earnedCard);

	}

	public int getSuitValueOfCard() {
		return CardSuit.valueOf(this.getCardOfTheTop().getSuitOfCard()).getValue();
	}

	public int getRankValueOfCard() {
		String cardRank = this.getCardOfTheTop().getRankOfCard();
		if ("2".equals(cardRank)) {
			return CardRank.Two.getValue();
		} else if ("3".equals(cardRank)) {
			return CardRank.Three.getValue();
		} else if ("4".equals(cardRank)) {
			return CardRank.Four.getValue();
		} else if ("5".equals(cardRank)) {
			return CardRank.Five.getValue();
		} else if ("6".equals(cardRank)) {
			return CardRank.Six.getValue();
		} else if ("7".equals(cardRank)) {
			return CardRank.Seven.getValue();
		} else if ("8".equals(cardRank)) {
			return CardRank.Eight.getValue();
		} else if ("9".equals(cardRank)) {
			return CardRank.Nine.getValue();
		} else {
			return CardRank.valueOf(this.getCardOfTheTop().getRankOfCard()).getValue();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}

}
