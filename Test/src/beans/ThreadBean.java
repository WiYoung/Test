package beans;

import java.sql.Date;

public class ThreadBean {
	private int     id;
	private String  title;
	private String  nickname;
	private String  message;
	private Date  update;
	private Date  insert;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Date getInsert() {
		return insert;
	}
	public void setInsert(Date insert) {
		this.insert = insert;
	}

}