package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.GeneratedValue;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

/*
 * In MySQL, the table structure can be seen as follows:
 * SHOW CREATE TABLE <tablename>.
 */
@Entity
public class CD {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Float price;
	private String description;
	@Lob
	@ElementCollection
	@CollectionTable(name = "track")
	@MapKeyColumn(name = "position") // Named by default as tracks_key, if not specified
	@Column(name = "title")
	private Map<Integer, String> tracks = new HashMap<>();

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

	public Map<Integer, String> getTracks() {
		return tracks;
	}

	public void setTracks(Map<Integer, String> tracks) {
		this.tracks = tracks;
	}
}