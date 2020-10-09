package cards;

public enum CardSuit {
	c(4), d(3), h(2), s(1);

	private int value;

	private CardSuit(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
}
