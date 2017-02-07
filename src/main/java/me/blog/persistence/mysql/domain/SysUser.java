package me.blog.persistence.mysql.domain;

import me.blog.persistence.object.BaseDomain;

public class SysUser extends BaseDomain {

	private static final long serialVersionUID = -6323408665755973183L;
	
	private String id;
	private String name;
	private String password;
	private String tel;

	@Override
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setId(String id) {
		this.id = id;
	}
}
