package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Customer;
import repository.CustomerRepository;


public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(){
		
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
