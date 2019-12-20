import java.util.ArrayList;
import java.util.List;

public class RestaurantDatabaseHelper {
	private List<Restaurant> restaurantList;
	public RestaurantDatabaseHelper(){
		restaurantList = new ArrayList<Restaurant>();
	}
	public void addRestaurant(Restaurant restaurant) {
		restaurantList.add(restaurant);
	}
	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}
}
