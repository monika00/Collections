package repository;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class HBRepositoryImpl implements CustomerRepository {
	
	/* (non-Javadoc)
	 * @see repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll(){
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstName("Kamtas");
		customer.setLastName("Plautis");
		
		customers.add(customer);
		
		return customers;
	}
}
