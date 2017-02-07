package me.blog.persistence.domain.respository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8040824879437351338L;
	
	@Id
	@GeneratedValue
	private String id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="TEL")
	private String tel;
	
	protected SysUser() {
		
	}
	
	public SysUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
