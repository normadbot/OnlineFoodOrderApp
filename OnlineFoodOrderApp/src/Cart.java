import java.util.Map;

public class Cart {
	private CartDetailsWrapperHelper cartDetailWrapperHelper;
	private Order customerOrderDetails;
	private Restaurant restaurantDetails;
	private Customer customerDetails;
	public Cart(CartDetailsWrapperHelper cartDetailWrapperHelper) {
		this.cartDetailWrapperHelper= cartDetailWrapperHelper;
		this.customerOrderDetails=cartDetailWrapperHelper.getCustomerOrderDetails();
		this.customerDetails=cartDetailWrapperHelper.getCustomerDetails();
		this.restaurantDetails= cartDetailWrapperHelper.getRestaurantDetails();
		
	}
	public void displayCart() {
		System.out.println("Hi... "+ customerDetails.getCustName()+" Your Order from Restaurant: "+restaurantDetails.getRestaurantName());
		System.out.println("Your Cart Contains\n<=========>");		
		Map<Integer,Integer> itemQuantityMap= customerOrderDetails.getItemAndQuantityMap();
		int i=1;
		for(Item item : restaurantDetails.getRestaurantItems()) {
			if(itemQuantityMap.containsKey(item.getItemId())) {
				Integer itemQuantity=itemQuantityMap.get(item.getItemId());
				System.out.println((i++)+") Food Item: "+item.getItemName()+" Quantity: "+itemQuantity+
						" Price: "+(item.getItemPrice()*itemQuantity));
			}
		}
		
		System.out.println("<=========>");
	}
	public void displayCartTotal() {
		System.out.print("Total Amount of Cart: ");
		Map<Integer,Integer> itemQuantityMap= customerOrderDetails.getItemAndQuantityMap();
		double totalAmount=0;
		for(Item item : restaurantDetails.getRestaurantItems()) {
			if(itemQuantityMap.containsKey(item.getItemId())) {
				totalAmount=totalAmount+item.getItemPrice()*itemQuantityMap.get(item.getItemId());
			}
		}
		System.out.print(totalAmount+"\n");
	}
	public void decreaseItemQuantity() {
		
	}
	public void increaseItemQuantity() {
		
	}
}
