package me.blog.service;

import me.blog.exception.PassPortException;
import me.blog.persistence.mysql.domain.SysUser;

public interface UserSerive {
	String service_name = "userService";
	
	void registered(SysUser user);
	
	SysUser Login(String userName, String passWord) throws PassPortException;
	
}
