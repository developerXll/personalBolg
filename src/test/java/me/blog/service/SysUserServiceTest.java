package me.blog.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.blog.PersonalBlogApp;
import me.blog.exception.PassPortException;
import me.blog.persistence.mysql.domain.SysUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PersonalBlogApp.class)
public class SysUserServiceTest {
	@Autowired
	private UserSerive userService;
	
	@Test
	public void testLogin() {
		SysUser user = null;
		try {
			user = userService.Login("test", "pwd");
		} catch (PassPortException e) {
			e.printStackTrace();
		}
		assertTrue("logion error", user != null);
		assertTrue("logion error", user.toString().contains("name=test,password=pwd"));
	}

}
