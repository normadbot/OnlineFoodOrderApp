import java.util.ArrayList;
import java.util.List;

class Restaurant {
	private int restaurantId;	
	private String restaurantName;
	private List<Item> restaurantItems;
	
	Restaurant(int restaurantId,String restaurantName){
		this.restaurantItems = new ArrayList<Item>();
		this.restaurantId=restaurantId;
		this.restaurantName=restaurantName;
	}
	public void addItem(Item item) {
		restaurantItems.add(item);
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public List<Item> getRestaurantItems() {
		return restaurantItems;
	}
	
	
}
