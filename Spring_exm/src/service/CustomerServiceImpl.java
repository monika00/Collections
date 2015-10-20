package service;

import java.util.List;

import model.Customer;
import repository.CustomerRepository;
import repository.HBRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository = new HBRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see service.CustomerService#findAll()
	 */
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
