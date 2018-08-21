package model.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CompactDisk {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Float price;
	private String description;
	@ManyToMany(mappedBy = "appearsOnCDs")
	private List<Artist> createdByArtists;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Artist> getCreatedByArtists() {
		return createdByArtists;
	}

	public void setCreatedByArtists(List<Artist> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + "]";
	}
}
