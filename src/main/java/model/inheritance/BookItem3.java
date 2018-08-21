package model.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "book_id")),
		@AttributeOverride(name = "title", column = @Column(name = "book_title")),
		@AttributeOverride(name = "description", column = @Column(name = "book_description")) })
public class BookItem3 extends RootItem3 {
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
