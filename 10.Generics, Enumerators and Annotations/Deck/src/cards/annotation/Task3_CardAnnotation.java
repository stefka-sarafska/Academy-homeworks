package cards.annotation;

import swift.desk.Card;
import swift.desk.CardRank;
import swift.desk.CardSuit;

public class Task3_CardAnnotation {
	public static void main(String[] args) {
		Class cardElement = Card.class;
		Class suitElement = CardSuit.class;
		Class rankElement = CardRank.class;

		printAnnotation(cardElement, Card.class.getSimpleName());
		printAnnotation(suitElement, CardSuit.class.getSimpleName());
		printAnnotation(rankElement, CardRank.class.getSimpleName());
	}

	private static void printAnnotation(Class classElement, String nameOfClass) {
		CardsAnnotation parameter = (CardsAnnotation) classElement.getAnnotation(CardsAnnotation.class);
		String type = parameter.type();
		String category = parameter.category();
		String description = parameter.description();
		System.out.println(nameOfClass + " " + type + " " + description);
	}

}
