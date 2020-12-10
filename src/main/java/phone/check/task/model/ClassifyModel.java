package phone.check.task.model;

import java.util.ArrayList;
import java.util.List;

public class ClassifyModel {
	private Customer Customer;
	private boolean valid;
	
	public ClassifyModel(Customer customer, boolean valid) {
		this.Customer = customer;
		this.valid = valid;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	//for testing purpose
	public boolean equals(Object obj){
		ClassifyModel classifyModel = (ClassifyModel) obj;
        boolean status = false;
        if(this.Customer.equals(classifyModel.getCustomer())
                && this.valid == classifyModel.isValid()){
            status = true;
        }
        return status;
    }


}
