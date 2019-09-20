package proxy;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public Customer findCustomerById(int customerID) {
		// TODO Auto-generated method stub
		return new Customer(customerID, "John");
	}

}
