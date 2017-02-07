package me.blog.persistence.mongo.domain;

import java.util.Date;

import me.blog.persistence.object.BaseDomain;

public class Comment extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1977775405789387051L;

	private String content;
	private String user;
	private Date insertDate;

	@Override
	public String getId() {
		return this.toString();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}
