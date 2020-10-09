package swift.desk;

import cards.annotation.CardsAnnotation;

@CardsAnnotation(
		type="enum",
		description="Contains a set of constants for the ranks of a card."
		)

public enum CardRank {
	Two,
	Three,
	Four,
	Five,
	Six,
	Seven,
	Eight,
	Nine,
	Ten,
	Jack,
	Queen,
	King,
	Ace
}
