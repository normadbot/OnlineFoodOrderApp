import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Enums.Categories;

public class MenuSelection {
	
	private List<Item> menuItems;
	public MenuSelection() {
		menuItems= new ArrayList<Item>();
	}
	
	
	public void displayMenu() {
		if(menuItems.isEmpty()) {
			System.out.println("Menu Not loaded");
			return;
		}
		System.out.println("/===================================================/");
		displayFoodCategory(menuItems,Categories.VS);
		displayFoodCategory(menuItems,Categories.EM);
		displayFoodCategory(menuItems,Categories.NS);
		displayFoodCategory(menuItems,Categories.NM);
		displayFoodCategory(menuItems,Categories.ES);
		displayFoodCategory(menuItems,Categories.EM);
		displayFoodCategory(menuItems,Categories.VD);
		displayFoodCategory(menuItems,Categories.ED);
		displayFoodCategory(menuItems,Categories.ND);
		System.out.println("/===================================================/");
		
	}
	private void displayFoodCategory(List<Item> menuItemList,Categories category) {
		List<Item> menuCategoryList= menuItemList.stream().filter(varCategory->varCategory.getItemCategory().equals(category)).collect(Collectors.toList());
		if(menuCategoryList.isEmpty())return;
		System.out.println("/--------------------------/"+category.getCategoryLabel()+"/--------------------------/");
		for(Item item: menuCategoryList) {
			System.out.println("=> "+item.getItemName()+" Order code: "+item.getItemId());
		}
		
	}
	public void loadRestaurantMenu(Restaurant restaurant) {
		menuItems=restaurant.getRestaurantItems();
	}
	
}
