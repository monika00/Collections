package main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CustomerServiceImpl_anno;
import service.CustomerService_anno;


public class Application_anno {

	public static void main(String[] args) {
		
		//CustomerService service = new CustomerServiceImpl();
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerService_anno service = appContext.getBean("customerService_anno", CustomerService_anno.class);
		
		System.out.println(service.findAll().get(0).getFirstName());

	}

}
