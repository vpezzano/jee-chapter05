package model.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "t_customer1")
public class CustomerItemA {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	/*
	 * If you do not use @OneToOne annotation with cascade, you will need to save
	 * not only the owner side (CustomerItemA), but also the owned side
	 * (AddressItem). The join column address_id will be created in the table
	 * corresponding to the CustomerItemA entity.
	 */
	private AddressItem address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressItem getAddress() {
		return address;
	}

	public void setAddress(AddressItem address) {
		this.address = address;
	}
}