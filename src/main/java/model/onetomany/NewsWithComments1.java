package model.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class NewsWithComments1 {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String content;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderColumn(name = "posted_index")
	private List<Comment1> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment1> getComments1() {
		return comments;
	}

	public void setComments1(List<Comment1> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "NewsWithComments1 [id=" + id + ", content=" + content + ", comments=" + comments + "]";
	}
}
