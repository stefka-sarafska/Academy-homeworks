package swift.desk;

import cards.annotation.CardsAnnotation;


@CardsAnnotation(
		type="enum",
		description="Contains a set of constants for the suits of a card."
		)
public enum CardSuit {
	Clubs,
	Diamonds,
	Hearts,
	Spades
}
