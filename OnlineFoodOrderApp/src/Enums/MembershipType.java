package Enums;

public enum MembershipType {
	Gold(30),
	Platinum(40);
	private int membershipDiscountPercentage;
	private MembershipType(int membershipDiscountPercentage) {
		this.membershipDiscountPercentage=membershipDiscountPercentage;
	}
	public int getMembershipDiscountPercentage() {
		return membershipDiscountPercentage;
	}
}
