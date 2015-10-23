package repository;

import java.util.ArrayList;
import java.util.List;

import model.Customer_anno;

import org.springframework.stereotype.Repository;

@Repository("customerRepository_anno")
public class HBRepositoryImpl_anno implements CustomerRepository_anno {
	

	public List<Customer_anno> findAll(){
		
		List<Customer_anno> customers = new ArrayList<Customer_anno>();
		
		Customer_anno customer = new Customer_anno();
		
		customer.setFirstName("Kamtas");
		customer.setLastName("Plautis");
		
		customers.add(customer);
		
		return customers;
	}
}
