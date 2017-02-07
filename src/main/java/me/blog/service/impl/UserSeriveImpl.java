package me.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.blog.exception.PassPortException;
import me.blog.object.BaseService;
import me.blog.persistence.mysql.domain.SysUser;
import me.blog.persistence.mysql.mapper.SysUserMapper;
import me.blog.service.UserSerive;

@Service(UserSerive.service_name)
@Transactional(rollbackFor = Exception.class)
public class UserSeriveImpl extends BaseService implements UserSerive {
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public void registered(SysUser user) {
		userMapper.insert(user);
	}

	@Override
	public SysUser Login(String userName, String passWord) throws PassPortException {
		SysUser user = userMapper.findUserByName(userName);
		if(user == null) throw new PassPortException("Cann't find userName");
		if(! user.getPassword().equals(passWord)) throw new PassPortException("password error");
		log("Authentication is successful");
		return user;
	}

}
