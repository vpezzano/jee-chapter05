package model.onetomany;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String nickname;
	private String content;
	private Integer note;
	@Column(name = "posted_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar postedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Calendar getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Calendar postedDate) {
		this.postedDate = postedDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", nickname=" + nickname + ", content=" + content + ", note=" + note
				+ ", postedDate=" + postedDate + "]";
	}
}