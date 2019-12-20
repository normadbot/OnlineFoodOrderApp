
public class CartDetailsWrapperHelper {
	private  Customer customerDetails;
	private  Order customerOrderDetails;
	private  Restaurant restaurantDetails;
	public  CartDetailsWrapperHelper(Customer customerDetails,Order customerOrderDetails,Restaurant restaurantDetails) {
		this.customerDetails=customerDetails;
		this.customerOrderDetails=customerOrderDetails;
		this.restaurantDetails=restaurantDetails;
	}
	
	
	public  Customer getCustomerDetails() {
		return customerDetails;
	}
	public  Order getCustomerOrderDetails() {
		return customerOrderDetails;
	}
	public  Restaurant getRestaurantDetails() {
		return restaurantDetails;
	}
	
	
}
