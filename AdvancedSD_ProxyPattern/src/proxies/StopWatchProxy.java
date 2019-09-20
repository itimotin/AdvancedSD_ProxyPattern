package proxies;
//import proxy.CustomerDAO;
//import proxy.Customer;
import timer.StopWatch;

import java.lang.reflect.*;

public class StopWatchProxy implements InvocationHandler {

	private Object target;
	
//	CustomerDAO customerDAO;
	
	public StopWatchProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object returnValue = method.invoke(target, args);
		stopWatch.stop();
		System.out.println("Time elapsed:" + stopWatch.getMillis());
		
		return returnValue;
	}
	
//	@Override
//	public Customer findCustomerById(int customerID) {
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//		Customer customer = this.customerDAO.findCustomerById(customerID);
//		stopWatch.stop();
//		System.out.println("Time elapsed:" + stopWatch.getMillis());
//		
//		return customer;
//	}
}
