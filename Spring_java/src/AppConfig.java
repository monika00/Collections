import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import repository.CustomerRepository;
import repository.HBRepositoryImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

@Configuration
@ComponentScan({"model", "service", "repository"})
public class AppConfig {
	
	/*@Bean(name = "customerService")
	public CustomerService getCustomerService(){
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCustomerRepository(getCustomerRepository());
		return customerService;
	}*/
	
	/*@Bean(name = "customerService")
	public CustomerService getCustomerService(){
		CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());
		return customerService;
	}*/
	
	//with @Autowired
	@Bean(name = "customerService")
	public CustomerService getCustomerService(){
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		return customerService;
	}
	
	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository(){
		return new HBRepositoryImpl();
	}
}
