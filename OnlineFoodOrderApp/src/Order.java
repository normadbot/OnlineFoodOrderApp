import java.util.HashMap;
import java.util.Map;

class Order {
	private int orderId;
	private int orderCustId;
	private String orderCustName;
	private Map<Integer,Integer> itemAndQuantityMap;
	private float totalAmmount; 
    Order(){
		this.itemAndQuantityMap= new HashMap<Integer,Integer>();
	}
   public void placeOrder(TakeOrderSlip orderSlip) {
	   itemAndQuantityMap= orderSlip.getCustOrder();
   }
   
	public Map<Integer, Integer> getItemAndQuantityMap() {
		return itemAndQuantityMap;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getOrderCustId() {
		return orderCustId;
	}
	public String getOrderCustName() {
		return orderCustName;
	}
	public float getTotalAmmount() {
		return totalAmmount;
	}
    
	
}
