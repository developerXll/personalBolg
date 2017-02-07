package me.blog.persistence.object;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class BaseDomain implements Serializable{

	private static final long serialVersionUID = 103883483423446951L;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public abstract Serializable getId();

}
