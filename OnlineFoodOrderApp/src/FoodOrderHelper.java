
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import Enums.Categories;
import Enums.MembershipType;

class FoodOrderHelper {
	static Logger logger = Logger.getLogger(FoodOrderHelper.class.getName());
	public FoodOrderHelper() {
		
	}
	private static Map<Integer, Restaurant> getRestaurantIdMap(RestaurantDatabaseHelper restaurantDatabaseHelper) {
		int i=1;
		Map<Integer,Restaurant> restaurantMap = new HashMap<Integer,Restaurant>();
		for(Restaurant restaurant:restaurantDatabaseHelper.getRestaurantList()) {
			restaurantMap.put(i++,restaurant);
		}
		return restaurantMap;
	}
	private static RestaurantDatabaseHelper initializeRestaurantDatabase() {
		RestaurantDatabaseHelper restaurantDatabaseInstance =  new RestaurantDatabaseHelper();
		Restaurant restaurant1 = new Restaurant(1, "ShivSagar");
		restaurant1.addItem(new Item(1001,"Paneer-Tikka",180,true,(Categories.VS)));
		restaurant1.addItem(new Item(1002,"Chicken-Tikka",220,true,(Categories.NS)));
		restaurant1.addItem(new Item(1003,"Kadai-Paneer",280,true,(Categories.VM)));
		restaurant1.addItem(new Item(1004,"Butter-Chicken",320,true,(Categories.NM)));
		restaurant1.addItem(new Item(1005,"Vanilla Ice-Cream",100,true,(Categories.VD)));
		restaurant1.addItem(new Item(1006,"Chocolate-Cake",500,true,(Categories.ED)));
		restaurant1.addItem(new Item(1007,"Mushroom Fried",180,true,(Categories.VS)));
		Restaurant restaurant2 = new Restaurant(2, "Hyderabadi-Spice");
		restaurant2.addItem(new Item(2001,"Chicken-Biryani",300,true,(Categories.NM)));
		restaurant2.addItem(new Item(2002,"Tandoori-Chicken",210,true,(Categories.NS)));
		restaurant2.addItem(new Item(2003,"Mutton-Biryani",300,true,(Categories.NM)));
		restaurant2.addItem(new Item(2004,"Egg-Biryani",300,true,(Categories.EM)));
		restaurantDatabaseInstance.addRestaurant(restaurant1);
		restaurantDatabaseInstance.addRestaurant(restaurant2);
		return restaurantDatabaseInstance;
	}
	private static CustomerDatabaseHelper initializeCustomerDatabase() {
		CustomerDatabaseHelper customerDatabaseInstance = new CustomerDatabaseHelper();
		Customer custInstance1 = new Customer(1,"Sarabjeet","9874563210","saby@gmail.com",
				new Address("7/150","Malviya Nagar","Jaipur","Rajasthan","302017"),new Membership("1a",10,MembershipType.Gold));
		Customer custInstance2 = new Customer(2,"Ron","8874563210","ron@gmail.com",
				new Address("9/11","Malviya Nagar","Delhi","Rajasthan","502087"),new Membership("2b",20,MembershipType.Gold));
		Customer custInstance3 = new Customer(3,"John","9899563210","john@gmail.com",
				new Address("D-49","Shanti Nagar","Raipur","Chattisgarh","963852"),new Membership("3c",40,MembershipType.Platinum));
		customerDatabaseInstance.addCustomer(custInstance1);
		customerDatabaseInstance.addCustomer(custInstance2);
		customerDatabaseInstance.addCustomer(custInstance3);
		return customerDatabaseInstance;
	}

	public static void main(String[] args) 
	{
		DOMConfigurator.configure("log4j.xml");
		Scanner sc=new Scanner(System.in); 
		RestaurantSelection restaurantSelection = new RestaurantSelection();
		MenuSelection menuSelection = new MenuSelection();
		TakeOrderSlip orderSlipInstance;
		Order placeOrderInstance;
		CartDetailsWrapperHelper cartDetailsHelper;
		Cart cartInstance;
		RestaurantDatabaseHelper restaurantDatabaseHelper=initializeRestaurantDatabase();
		CustomerDatabaseHelper customerDatabaseInstance = initializeCustomerDatabase();
		Map<Integer,Restaurant> restaurantMap = getRestaurantIdMap(restaurantDatabaseHelper);
		
		logger.debug("welcome to Food App \n Kindly login by username: \n");
		String userName = sc.nextLine();
		Customer userNameInstance = customerDatabaseInstance.ifCustomerFound(userName);
		
		if(userNameInstance==null) {
			logger.debug("Cannot find user \n bye :|");
			System.exit(0);
		}
		System.out.println("Welcome: "+userName);
		
		char ch ='Y';
		while(ch=='Y') {
			System.out.println("Select the Restaurant: "+userName);
			Restaurant selctedRestaurant=restaurantSelection.selectRestaurant(restaurantMap);
			if(selctedRestaurant==null) {
				System.out.println("restaurant not selected!!");
				continue;
			}
			menuSelection.loadRestaurantMenu(selctedRestaurant);
			menuSelection.displayMenu();
			
			orderSlipInstance= new TakeOrderSlip();
			placeOrderInstance= new Order();
			
			System.out.println("Kindly enter the food Product ->  Number of Items you want of that Product");
			char isFinalOrder='y';
			while(isFinalOrder=='y') {
				System.out.print("Order Code: ");
				Integer orderCode =sc.nextInt();
				System.out.print("\n Quantity of Order: ");
				Integer orderQuantity =sc.nextInt();
				orderSlipInstance.takeOrderItem(orderCode, orderQuantity);
				System.out.println("\n You want more ? y/N");
				isFinalOrder=sc.next().charAt(0);
			}
			if(orderSlipInstance.getCustOrder().isEmpty())System.out.println("Empty");
			placeOrderInstance.placeOrder(orderSlipInstance);
			cartDetailsHelper = new CartDetailsWrapperHelper(userNameInstance,placeOrderInstance , selctedRestaurant);
		    cartInstance = new Cart(cartDetailsHelper);
		    cartInstance.displayCart();
		    cartInstance.displayCartTotal();
			break;
		}
		
		
		
	}
	

}
