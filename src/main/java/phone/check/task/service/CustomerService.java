package phone.check.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import phone.check.task.dao.CustomerDao;
import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;

@Service
public class CustomerService {
	private final CustomerDao customerdao;

	@Autowired
	public CustomerService(@Qualifier("sqlite")CustomerDao customerdao) {
		this.customerdao = customerdao;
	}
	
	public int addPerson(Customer customer) {
		return customerdao.insertCustomer(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerdao.selectAllCustomers();
	}
	
	public List<ClassifyModel> getCustomersByCountry(String countryName) {
		return customerdao.getCustomersByCountry(countryName);
	}
}
