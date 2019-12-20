import java.util.Map;
import java.util.Scanner;

public class RestaurantSelection {
	Scanner sc ;
	public RestaurantSelection() {
		sc=new Scanner(System.in);
	}
	public Restaurant selectRestaurant(Map<Integer,Restaurant> restaurantMap) {
		
		for(Map.Entry<Integer,Restaurant> restaurantEntry:restaurantMap.entrySet()) {
			System.out.println(restaurantEntry.getKey()+" ) "+restaurantEntry.getValue().getRestaurantName());
		}
		System.out.print("Select Integer no.");
		Integer choiceNo = sc.nextInt();
		Restaurant getChoiceRestaurant=restaurantMap.get(choiceNo);
		if(getChoiceRestaurant==null)return null;
		
		return getChoiceRestaurant;
	}
	
}
