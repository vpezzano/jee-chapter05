package model.inheritance;

import javax.persistence.Entity;

@Entity
public class CDItem extends RootItem {
	private String musicCompany;
	private Integer numberOfCDs;
	private Float totalDuration;
	private String genre;

	public String getMusicCompany() {
		return musicCompany;
	}

	public void setMusicCompany(String musicCompany) {
		this.musicCompany = musicCompany;
	}

	public Integer getNumberOfCDs() {
		return numberOfCDs;
	}

	public void setNumberOfCDs(Integer numberOfCDs) {
		this.numberOfCDs = numberOfCDs;
	}

	public Float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CDItem [musicCompany=" + musicCompany + ", numberOfCDs=" + numberOfCDs + ", totalDuration="
				+ totalDuration + ", genre=" + genre + "]";
	}
}
