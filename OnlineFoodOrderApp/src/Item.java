import Enums.Categories;

class Item {
	private int itemId;
	private String itemName;
	private double itemPrice;
	private boolean isActive;
	private Categories itemCategory;
	
	public Item(int itemId,String itemName,double itemPrice,boolean isActive,Categories itemCategory) {
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.isActive=isActive;
		this.itemCategory=itemCategory;
	}
	public String getItemName() {
		return itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public boolean isActive() {
		return isActive;
	}
	public Categories getItemCategory() {
		return itemCategory;
	}	
}
