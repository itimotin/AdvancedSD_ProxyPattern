package proxies;
import log.Logger;
import proxy.CustomerDAO;
import proxy.Customer;

public class LoggingProxy implements CustomerDAO {

	CustomerDAO customerDAO ;
	Logger logger = new Logger();
	
	public LoggingProxy(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public Customer findCustomerById(int customerID) {
		
		Customer customer = this.customerDAO.findCustomerById(customerID);
		logger.log("getting cusstomer with id = "+ customerID);
		
		return customer;
	}
	
}
