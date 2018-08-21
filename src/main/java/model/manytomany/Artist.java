package model.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Artist {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "jnd_art_cd", joinColumns = @JoinColumn(name = "artist_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
	private List<CompactDisk> appearsOnCDs;

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

	public List<CompactDisk> getAppearsOnCDs() {
		return appearsOnCDs;
	}

	public void setAppearsOnCDs(List<CompactDisk> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
