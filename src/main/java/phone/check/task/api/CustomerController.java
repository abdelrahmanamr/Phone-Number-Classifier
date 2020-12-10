package phone.check.task.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;
import phone.check.task.service.CustomerService;


@RestController
public class CustomerController {
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService personService) {
		this.customerService = personService;
	}
	
//	@PostMapping
//	public void addCustomer(@Validated @NonNull @RequestBody Customer customer) {
//		customerService.addPerson(customer);
//	}
	
	@RequestMapping(value= "api/v1/customer", method = RequestMethod.GET)
	public List<Customer> getAllPeople() {
		return customerService.getAllCustomers();
	}
	
//	@GetMapping(path = "{countryName}")
	@RequestMapping(value= "api/v1/customer/{countryName}", method = RequestMethod.GET)
	public List<ClassifyModel> getPersonById(@PathVariable("countryName") String countryName) {
		return customerService.getCustomersByCountry(countryName);

	}
	
}
