package proxy;

public class Customer {
	private int customerID;
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	public Customer(int customerID, String name) {
		this.customerID = customerID;
		this.name = name;
	}
	
	
	
}
