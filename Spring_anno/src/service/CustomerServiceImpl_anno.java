package service;

import java.util.List;

import model.Customer_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CustomerRepository_anno;

@Service("customerService_anno")
public class CustomerServiceImpl_anno implements CustomerService_anno {
	
	
	private CustomerRepository_anno customerRepository;

	public List<Customer_anno> findAll(){
		return customerRepository.findAll();
	}
	
	@Autowired
	public void setCustomerRepository(CustomerRepository_anno customerRepository) {
		this.customerRepository = customerRepository;
		System.out.println("Injection");
	}
	
	

}
