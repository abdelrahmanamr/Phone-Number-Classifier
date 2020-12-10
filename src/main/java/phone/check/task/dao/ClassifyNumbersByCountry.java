package phone.check.task.dao;

import java.util.ArrayList;
import java.util.List;

import phone.check.task.model.ClassifyModel;
import phone.check.task.model.Customer;

public class ClassifyNumbersByCountry {
	
	public static List<ClassifyModel> Classifier(String country, List<Customer> database){
		
		List <ClassifyModel> result = new ArrayList<ClassifyModel>();
		for(int i =0; i<database.size();i++) {
			Customer currentCustomer = database.get(i);
			switch(country.toLowerCase()) {
			case "cameroon" :
				if(checkNumberBelongsToCountry(currentCustomer.getPhoneNumber(), "(237)")) {
					ClassifyModel newClassifyModel= new ClassifyModel(currentCustomer, false);
					if(checkNumberValidity(currentCustomer.getPhoneNumber(),"\\(237\\)\\ ?[2368]\\d{7,8}$")) {
						newClassifyModel.setValid(true);
					}
					result.add(newClassifyModel);
				}
				break;
			case "ethiopia" :
				if(checkNumberBelongsToCountry(currentCustomer.getPhoneNumber(), "(251)")) {
					ClassifyModel newClassifyModel= new ClassifyModel(currentCustomer, false);
					if(checkNumberValidity(currentCustomer.getPhoneNumber(),"\\(251\\)\\ ?[1-59]\\d{8}$")) {
						newClassifyModel.setValid(true);
					}
					result.add(newClassifyModel);
				}
				break;
			case "morocco" :
				if(checkNumberBelongsToCountry(currentCustomer.getPhoneNumber(), "(212)")) {
					ClassifyModel newClassifyModel= new ClassifyModel(currentCustomer, false);
					if(checkNumberValidity(currentCustomer.getPhoneNumber(),"\\(212\\)\\ ?[5-9]\\d{8}$")) {
						newClassifyModel.setValid(true);
					}
					result.add(newClassifyModel);
				}
				break;
			case "mozambique" :
				if(checkNumberBelongsToCountry(currentCustomer.getPhoneNumber(), "(258)")) {
					ClassifyModel newClassifyModel= new ClassifyModel(currentCustomer, false);
					if(checkNumberValidity(currentCustomer.getPhoneNumber(),"\\(258\\)\\ ?[28]\\d{7,8}$")) {
						newClassifyModel.setValid(true);
					}
					result.add(newClassifyModel);
				}
				break;
			case "uganda" :
				if(checkNumberBelongsToCountry(currentCustomer.getPhoneNumber(), "(256)")) {
					ClassifyModel newClassifyModel= new ClassifyModel(currentCustomer, false);
					if(checkNumberValidity(currentCustomer.getPhoneNumber(),"\\(256\\)\\ ?\\d{9}$")) {					
						newClassifyModel.setValid(true);
					}
					result.add(newClassifyModel);
				}
				break;
			default : break;
			
			}
		}
		
		
		return result;
	}
	
	
	private static boolean checkNumberBelongsToCountry(String phoneNumber, String countryCode ) {
		return phoneNumber.split(" ")[0].equals(countryCode); // compare the first part of number with the country code 
	}
	private static boolean checkNumberValidity(String phoneNumber, String regex ) {
		return phoneNumber.matches(regex); // compare the first part of number with the country code 
	}
	
	
}
