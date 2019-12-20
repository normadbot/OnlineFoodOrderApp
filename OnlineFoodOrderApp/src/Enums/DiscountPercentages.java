package Enums;

public enum DiscountPercentages {
	Ten(10),
	Twenty(20),
	Thirty(30),
	Forty(40),
	Fifty(50);
	
	
	private int percentage;
	private DiscountPercentages(int c) {
		this.percentage=c;
	}
	public int getDiscountPercentage() {
		return this.percentage;
	}
}
