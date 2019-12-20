
public class Customer {
		private int custId;
		private String custName;
		private String custMobile;
		private String custEmail;
		private Address custAddress;
		private Membership custMembership;
		public Customer(int id,String name,String mobile,String email,Address address,Membership membership) {
			this.custId=id;
			this.custName=name;
			this.custMobile=mobile;
			this.custEmail=email;
			this.custAddress=address;
			this.custMembership=membership;
		}
		public String getCustName() {
			return custName;
		}
		public int getCustId() {
			return custId;
		}
		public String getCustMobile() {
			return custMobile;
		}
		public String getCustEmail() {
			return custEmail;
		}
		public Address getCustAddress() {
			return custAddress;
		}
		public Membership getCustMembership() {
			return custMembership;
		}
		
}
