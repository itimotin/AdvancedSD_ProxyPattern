package accountpackage;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
	  Collection<Account> accountList = new ArrayList<Account>();

	  public void addAccount(String accountNumber, Customer customer){
	    Account account = new Account(accountNumber, customer);
	    accountList.add(account);
	    System.out.println("in execution of method addAccount");
	  }
	}