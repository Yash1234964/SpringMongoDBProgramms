package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.service.ICustomerManagementService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(DemoApplication.class, args);
		
		ICustomerManagementService service=applicationContext.getBean(ICustomerManagementService.class);
//		System.out.println(service.registerCustomer(null));
		
//		System.out.println(service.registerCustomer(new CustomerDTO(18,"Kohli",110.0f)));
//		service.findAllCustomers().forEach(System.out::println);
		
//		String msg =service.removeCustomer("6451eac61b1ecd365ccd89e3");
//		System.out.println(msg);
		
//		System.out.println(service.registerCustomer(new CustomerDTO(3,"Yash",450.0F)));
		
		service.registerCustomer(new CustomerDTO(45, "Rohith", 250.0f,"MI",9777888899L));
		
		
//		service.fetchCustomerByBillAmount(240.05f, 500.05f).forEach(System.out::println);
		
		((ConfigurableApplicationContext) applicationContext).close();
		
	}

}
