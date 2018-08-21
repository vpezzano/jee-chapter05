package model.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment1 {
	@Id
	@GeneratedValue
	private Long id;
	private String nickname;
	private String content;
	private Integer note;

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

	@Override
	public String toString() {
		return "Comment1 [id=" + id + ", nickname=" + nickname + ", content=" + content + ", note=" + note
				+ "]";
	}
}