import Enums.MembershipType;

public class Membership {
	private String membershipId;
	private int noOfTransactions;
	private MembershipType membershipType;
	public Membership(String membershipId,int noOfTransactions,MembershipType membershipType) {
		this.membershipId=membershipId;
		this.noOfTransactions=noOfTransactions;
		this.membershipType=membershipType;
	}
	public String getMembershipId() {
		return membershipId;
	}
	public int getNoOfTransactions() {
		return noOfTransactions;
	}
	public MembershipType getMembershipType() {
		return membershipType;
	}
	
	
	
	
}
