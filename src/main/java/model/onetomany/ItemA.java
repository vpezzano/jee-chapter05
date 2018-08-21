package model.onetomany;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemA {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar creationDate;
	/*
	 * If you do not use @OneToMany annotation with cascade, you will need to save
	 * not only the owner side (ItemA), but also all the collection items, and the
	 * default strategy will use a join table.
	 */
	private List<ItemLine> itemLines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
	}

	public List<ItemLine> getItemLines() {
		return itemLines;
	}

	public void setItemLines(List<ItemLine> itemLines) {
		this.itemLines = itemLines;
	}
}
