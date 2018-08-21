package model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "credit_card")
public class CreditCard {
	@Id
	@GeneratedValue
	private String number;
	@Temporal(TemporalType.DATE)
	private Calendar expiryDate;
	private Integer controlNumber;
	/*
	 * The default applied to an enum is @Enumerated, which by default
	 * corresponds to @Enumerated(EnumType.ORDINAL)
	 */
	private CreditCardType creditCardType;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}
}
