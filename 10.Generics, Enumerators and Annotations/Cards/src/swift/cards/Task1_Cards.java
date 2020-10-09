package swift.cards;

public class Task1_Cards {
	public static void main(String[] args) {

		for (CardSuit suit : CardSuit.values()) {
			if (suit == CardSuit.Spades) {
				System.out.println(suit);
				break;
			}
			System.out.print(suit + ", ");
		}
		for(CardRank rank:CardRank.values()) {
			if (rank == CardRank.Ace) {
				System.out.println(rank);
				break;
			}
			System.out.print(rank+", ");
		}
	}
}
