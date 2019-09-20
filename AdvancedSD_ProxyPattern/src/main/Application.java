package main;
import proxy.CustomerService;
import proxy.Customer;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(1);
		System.out.println("customer: " + customer.getName());
		System.out.println("=======================================\n");
		System.out.println("Second time call the same customer");
		customer = customerService.getCustomer(1);
		System.out.println("customer: " + customer.getName());
		
	}

}
