package phone.check.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;

public interface CustomerDao {

	int insertCustomer(UUID id, String name, String phoneNumber);
	
	default int insertCustomer( Customer customer) {
		UUID id = UUID.randomUUID();
		return insertCustomer(id,customer.getName(),customer.getPhoneNumber());
	}
	List<Customer> selectAllCustomers();
	List<ClassifyModel> getCustomersByCountry(String countryName);
}
