package phone.check.task.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	
	private UUID id;
	private String name;
	private String phoneNumber;
	
	public Customer( @JsonProperty("id")UUID id, @JsonProperty("name")String name,@JsonProperty("phoneNumber") String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	//for testing purpose
	public boolean equals(Object obj){
		Customer customer = (Customer) obj;
	    boolean status = false;
	    if(this.name.equalsIgnoreCase(customer.getName())
	        && this.id.equals(customer.getId())
	        && this.phoneNumber.equals(customer.getPhoneNumber())){
	        status = true;
	       }
	        return status;
	    }
	
}
