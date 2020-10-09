import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import cards.Card;
import cards.CardRank;
import cards.CardSuit;
import player.Player;

public class Task4_War {
	private static List<String> ranksFromEnum = addingRanksInList();
	private static List<String> suitsFromSuit = addingSuitsInList();
	private static LinkedList<Card> cardsForFirstPlayer = new LinkedList<>();
	private static LinkedList<Card> cardsForSecondPlayer = new LinkedList<>();
	private static Scanner sp = new Scanner(System.in);
	private static Player playerOne;
	private static Player playerTwo;
	private static int rounds = 0;

	public static void main(String[] args) {

		int numberOfCardsPerPlayer = Integer.parseInt(sp.nextLine());
		playerOne = addingCardsPerPlayer(numberOfCardsPerPlayer, cardsForFirstPlayer);
		playerTwo = addingCardsPerPlayer(numberOfCardsPerPlayer, cardsForSecondPlayer);
		battle(playerOne, playerTwo);
		printFinalResult();

	}

	private static void printFinalResult() {
		if (playerOne.getCards().size() > 0 && playerTwo.getCards().isEmpty()) {
			System.out.println("Player 1 wins on round " + rounds + ".");
		} else if (!playerTwo.getCards().isEmpty() && playerOne.getCards().isEmpty()) {
			System.out.println("Player 2 wins on round " + rounds + ".");
		} else {
			System.out.println("Game is draw on round " + rounds + ".");
		}
	}

	private static void battle(Player playerOne, Player playerTwo) {

		while (playerOne.getCards().size() > 0 && playerTwo.getCards().size() > 0) {
			int rankValuePlayerOne = playerOne.getRankValueOfCard();
			int rankValuePlayerTwo = playerTwo.getRankValueOfCard();
			rounds++;
			if (rankValuePlayerOne != rankValuePlayerTwo) {
				if (rankValuePlayerOne > rankValuePlayerTwo) {
					updatePlayersCards(playerOne);
				} else {
					updatePlayersCards(playerTwo);
				}
			} else {
				war();
			}
			// showCards();
		}
	}

	private static void showCards() {
		System.out.println("Round: " + rounds);
		for (Card card : playerOne.getCards()) {
			System.out.print(card + " ");
		}
		System.out.println();
		for (Card card : playerTwo.getCards()) {
			System.out.print(card + " ");
		}
		System.out.println();
	}

	private static void war() {
		LinkedList<Card> firstThreeCardsOfPlayerOne = new LinkedList<Card>();
		LinkedList<Card> firstThreeCardsOfPlayerTwo = new LinkedList<Card>();
		Card firstCardPlayerOne = (Card) playerOne.removeCardAndGetCard();
		Card firstCardPlayerTwo = (Card) playerTwo.removeCardAndGetCard();
		int firstSum = 0;
		int secondSum = 0;
		if (playerOne.getCards().size() <= 3) {
			for (int i = 0; i < playerOne.getCards().size(); i++) {
				firstSum += playerOne.getRankValueOfCard();
				firstThreeCardsOfPlayerOne.add(playerOne.removeCardAndGetCard());
				i--;
			}
		} else {
			for (int i = 0; i < 3; i++) {
				firstSum += playerOne.getRankValueOfCard();
				firstThreeCardsOfPlayerOne.add(playerOne.removeCardAndGetCard());
			}
		}
		if (playerTwo.getCards().size() <= 3) {
			for (int i = 0; i < playerTwo.getCardListSize(); i++) {
				secondSum += playerTwo.getRankValueOfCard();
				firstThreeCardsOfPlayerTwo.add(playerTwo.removeCardAndGetCard());
				i--;
			}
		} else {
			for (int i = 0; i < 3; i++) {
				secondSum += playerTwo.getRankValueOfCard();
				firstThreeCardsOfPlayerTwo.add(playerTwo.removeCardAndGetCard());
			}
		}
		checkWinner(firstSum, secondSum, firstThreeCardsOfPlayerOne, firstThreeCardsOfPlayerTwo, firstCardPlayerOne,
				firstCardPlayerTwo);
	}

	private static void checkWinner(int firstSum, int secondSum, LinkedList<Card> firstThreeCardsOfPlayerOne,
			LinkedList<Card> firstThreeCardsOfPlayerTwo, Card firstCardPlayerOne, Card firstCardPlayerTwo) {
		if (firstSum > secondSum) {
			playerOne.getCards().add(0, firstCardPlayerOne);
			playerOne.getCards().add(1, firstCardPlayerTwo);
			for (Card newCard : firstThreeCardsOfPlayerTwo) {
				playerOne.addCard(newCard);
			}
		} else if (secondSum > firstSum) {
			playerTwo.getCards().add(0, firstCardPlayerTwo);
			playerTwo.getCards().add(1, firstCardPlayerOne);
			for (Card newCard : firstThreeCardsOfPlayerTwo) {
				playerTwo.addCard(newCard);
			}
			for (Card newCard : firstThreeCardsOfPlayerOne) {
				playerTwo.addCard(newCard);
			}
		}
	}

	private static void updatePlayersCards(Player player) {
		if (player.equals(playerOne)) {
			playerOne.addCard(playerOne.getCardOfTheTop());
			playerOne.addCard(playerTwo.getCardOfTheTop());
			playerOne.removeCardAndGetCard();
			playerTwo.removeCardAndGetCard();
		} else if (player.equals(playerTwo)) {
			playerTwo.addCard(playerTwo.getCardOfTheTop());
			playerTwo.addCard(playerOne.getCardOfTheTop());
			playerOne.removeCardAndGetCard();
			playerTwo.removeCardAndGetCard();
		}

	}

	private static Player addingCardsPerPlayer(int numberOfCardsPerPlayer, LinkedList<Card> cards) {
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			String input = sp.next();
			String rank = String.valueOf(input.charAt(0));
			String suit = String.valueOf(input.charAt(1));
			if (checkRankAndSuit(rank, suit) != null) {
				cards.add(checkRankAndSuit(rank, suit));
			}
		}
		return new Player(cards);
	}

	private static Card checkRankAndSuit(String rank, String suit) {
		Card card = null;
		if (ranksFromEnum.contains(rank) && suitsFromSuit.contains(suit)) {
			card = new Card(rank, suit);
		}
		return card;
	}

	private static List<String> addingRanksInList() {
		List<String> ranks = new ArrayList<>();
		for (CardRank rank : CardRank.values()) {
			if (rank.getValue() < 10) {
				ranks.add(String.valueOf(rank.getValue()));
			} else {
				ranks.add(String.valueOf(rank));
			}
		}
		return ranks;
	}

	private static List<String> addingSuitsInList() {
		List<String> suits = new ArrayList<>();
		for (CardSuit rank : CardSuit.values()) {
			suits.add(String.valueOf(rank));
		}
		return suits;
	}

}
