package phone.check.task.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;

class ClassifyNumbersByCountryTest {

	@Test
	void testClassifierMethod() {
		// creating some dummy data for testing
		Customer customer1 = new Customer(UUID.randomUUID(), "Walid Hammadi", "(212) 6007989253");
		Customer customer2 = new Customer(UUID.randomUUID(), "Yosaf Karrouch", "(212) 698054317");
		Customer customer3 = new Customer(UUID.randomUUID(), "Younes Boutikyad", "(212) 6546545369");
		Customer customer4 = new Customer(UUID.randomUUID(), "Houda Houda", "(212) 6617344445");
		Customer customer5 = new Customer(UUID.randomUUID(), "Ogwal David", "(256) 7771031454");
		// inserting data to the a sample database 
		List<Customer> customers  = new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		
		List<ClassifyModel> actual = ClassifyNumbersByCountry.Classifier("Morocco", customers);
		
		// expected results of the test case
		List<ClassifyModel> expected = new ArrayList<>();
		ClassifyModel firstClassifyModel = new ClassifyModel(customer1,false);
		ClassifyModel secondClassifyModel = new ClassifyModel(customer2,true);
		ClassifyModel thirdClassifyModel = new ClassifyModel(customer3,false);
		ClassifyModel fourthClassifyModel = new ClassifyModel(customer4,false);
		
		expected.add(firstClassifyModel);
		expected.add(secondClassifyModel);
		expected.add(thirdClassifyModel);
		expected.add(fourthClassifyModel);
		
		//comparing the two outputs
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}

}
