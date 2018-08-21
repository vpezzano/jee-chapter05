package model.onetomany;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemB {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar creationDate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "join_item_line", joinColumns = @JoinColumn(name = "item_fk"), inverseJoinColumns = @JoinColumn(name = "item_line_fk"))
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
