import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TakeOrderSlip {
	private  Map<Integer,Integer> custOrder;
	public TakeOrderSlip() {
		custOrder= new HashMap<Integer,Integer>();
	}
	public void takeOrderItem(Integer itemCode,Integer quantity) {
		if(custOrder.isEmpty()||(!custOrder.containsKey(itemCode))) {
			custOrder.put(itemCode, quantity);
			return;
		}
		
		if(custOrder.containsKey(itemCode)) {
			Integer i = custOrder.get(itemCode);
			custOrder.put(itemCode,(i+quantity));
			return;
		}
		
	}
	public Map<Integer, Integer> getCustOrder() {
		return custOrder;
	}
	
}
