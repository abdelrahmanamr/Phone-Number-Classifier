package phone.check.task.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;

@Repository("sqlite")
public class CustomerDataAccessService implements CustomerDao {
	
	private final JdbcTemplate jdbcTemplate ;
	
	@Autowired
	public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insertCustomer(UUID id, String name, String phoneNumber) {
		// TODO Auto-generated method stub
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customer(id VARCHAR(100), name VARCHAR(100), phone VARCHAR(100), PRIMARY KEY(id))");
		jdbcTemplate.execute("INSERT INTO customer (id,name,phone) VALUES ('"+id+"','"+name+"','"+phoneNumber+"')");
		return 1;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		//Create the database table:
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customer(id VARCHAR(100), name VARCHAR(100), phone VARCHAR(100), PRIMARY KEY(id))");
		final String sql = "SELECT * FROM customer";
		return (List<Customer>) jdbcTemplate.query(sql, (resultSet, rowNum) -> new Customer(validatetUUID(resultSet.getString("id")),resultSet.getString("name"),resultSet.getString("phone")));
		// TODO Auto-generated method stub
	}

	@Override
	public List<ClassifyModel> getCustomersByCountry(String country) {
		// TODO Auto-generated method stub
		List<Customer> DB = selectAllCustomers();
		return ClassifyNumbersByCountry.Classifier(country, DB);
	}
	
	private static UUID validatetUUID(String string) {
		if(isUUID(string)) {
			return UUID.fromString(string);
		}
		else {
			return new UUID(0,Long.parseLong(string));
		}
	}
	
	private static boolean isUUID(String string) {
	      try {
	         UUID.fromString(string);
	         return true;
	      } catch (Exception ex) {
	         return false;
	      }
	   }
	
	
}
