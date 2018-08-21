package model.inheritance;

import javax.persistence.Entity;

@Entity
public class BookItem2 extends RootItem2 {
	private String isbn;
	private String publisher;
	private Integer nbOfPage;
	private Boolean illustrations;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

	@Override
	public String toString() {
		return "BookItem [isbn=" + isbn + ", publisher=" + publisher + ", nbOfPage=" + nbOfPage + ", illustrations="
				+ illustrations + "]";
	}
}
