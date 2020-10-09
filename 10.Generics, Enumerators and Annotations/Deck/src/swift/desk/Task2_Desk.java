package swift.desk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2_Desk {
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		addingCardsInList(cards);
		Collections.sort(cards);
		printAllCards(cards);

	}

	private static void addingCardsInList(List<Card> cards) {

	
			for (CardRank rank : CardRank.values()) {
				for (CardSuit suit : CardSuit.values()) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}

	private static void printAllCards(List<Card> cards) {
		for (Card card : cards) {
			System.out.println(card);
		}
	}

}
