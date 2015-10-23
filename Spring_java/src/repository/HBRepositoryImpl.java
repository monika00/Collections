package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import model.Customer;

public class HBRepositoryImpl implements CustomerRepository {
	
	@Value("${someProperty}")
	private String someValue;

	public List<Customer> findAll(){
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		//customer.setFirstName("Kamtas");
		customer.setFirstName(someValue);
		customer.setLastName("Plautis");
		
		customers.add(customer);
		
		return customers;
	}
}
