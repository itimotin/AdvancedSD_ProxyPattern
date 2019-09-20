package proxy;
import proxies.CachingProxy;
import proxies.LoggingProxy;
import proxies.StopWatchProxy;
import java.lang.reflect.Proxy;

public class CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	CustomerDAO cachingProxy = new CachingProxy(customerDAO);
	CustomerDAO loggingProxy = new LoggingProxy(cachingProxy);
//	CustomerDAO stopWatchProxy = new StopWatchProxy(loggingProxy);
	ClassLoader classLoader = CustomerDAO.class.getClassLoader();
	CustomerDAO stopWatchProxy = (CustomerDAO) Proxy.newProxyInstance(this.classLoader, new Class[] {CustomerDAO.class}, new StopWatchProxy(this.loggingProxy));
	
	public Customer getCustomer(int customerID) {
		return this.stopWatchProxy.findCustomerById(customerID);
	}
}
