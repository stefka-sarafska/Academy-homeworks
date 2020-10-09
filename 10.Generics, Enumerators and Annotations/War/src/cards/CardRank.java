package cards;

public enum CardRank {
	Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), T(10), J(11), Q(12), K(13), A(14);

	private int value;

	private CardRank(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
