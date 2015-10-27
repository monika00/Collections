package service;

import java.util.List;

import model.Customer;
import repository.CustomerRepository;


public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(){
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/* (non-Javadoc)
	 * @see service.CustomerService#findAll()
	 */
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
