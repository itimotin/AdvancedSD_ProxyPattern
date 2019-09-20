package proxies;
import java.util.HashMap;
import java.util.Map;

import proxy.Customer;
import proxy.CustomerDAO;


public class CachingProxy implements CustomerDAO {
	CustomerDAO customerDAO ;
	Map<Integer, Customer> customerCache = new HashMap<Integer, Customer>();
	
	
	public CachingProxy(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public Customer findCustomerById(int customerID) {
		Customer cachedCustomer = customerCache.get(customerID);
		if (cachedCustomer == null) {
			Customer customer = customerDAO.findCustomerById(customerID);
			customerCache.put(customerID, customer);
			System.out.println("Customer with id "+customerID +" didn't find in cache so we will insert now in cache.");
			return customer;
		} else {
			System.out.println("Customer with id " +customerID+ " founded in cache");
			return cachedCustomer;
		}
	}

}
