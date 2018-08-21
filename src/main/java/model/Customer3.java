package model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;

import java.util.Calendar;

/*
 * The AccessType defines whether the fields or the properties are used
 * for building the columns in the database. It's not advised to mix them,
 * as it has been done in this class.
 */
@Entity
@Access(AccessType.PROPERTY)
public class Customer3 {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	@Column(name = "PHONE_NUMBER", length = 15)
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;
	@Transient
	private Integer age;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar creationDate;

	@Id
	@GeneratedValue
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

	@Access(AccessType.PROPERTY)
	@Column(name = "PHONE_NUMBER", length = 555)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Calendar getBirthDate() {
		return dateOfBirth;
	}

	public void setBirthDate(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
}