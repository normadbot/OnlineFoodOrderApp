

import java.util.ArrayList;
import java.util.List;


class CustomerDatabaseHelper {
	private List<Customer> customerList;
	
	public CustomerDatabaseHelper() {
		customerList= new ArrayList<Customer>();
	}
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public  Customer ifCustomerFound(String custName) {
		for(Customer custElement: customerList) {
			if(custElement.getCustName().equalsIgnoreCase(custName)) {
				return custElement;
			}
		}
		return null;
	}
}
