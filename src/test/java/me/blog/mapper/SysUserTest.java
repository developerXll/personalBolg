package me.blog.mapper;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.blog.PersonalBlogApp;
import me.blog.persistence.mysql.domain.SysUser;
import me.blog.persistence.mysql.mapper.SysUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PersonalBlogApp.class)
public class SysUserTest {
	
	@Autowired
	private SysUserMapper mapper;
	
	@Test
	public void testLoad() {
		SysUser user = mapper.load("1");
		assertTrue("user get error", user != null);
		assertTrue("user get data error", user.toString().contains("id=1,name=test,password=pwd,tel=111"));
	}
	
	@Test
	public void testInsert() {
		SysUser user = new SysUser();
		user.setName("test2");
		user.setPassword("password2");
		user.setTel("133");
		mapper.insert(user);
		assertTrue("insert data error", user.getId() != null);
	}
	
	@Test
	public void testUpdate() {
		SysUser user = mapper.load("1");
		user.setName("test2");
		user.setPassword("password2");
		user.setTel("133");
		mapper.update(user);
		System.out.println(user.getId());
		assertTrue("update data error", user != null);
	}
	
	@Test
	public void testSelectAll() {
		List<SysUser> users =  mapper.findAll();
		assertTrue("select all data error", users != null);
		assertTrue("select data number error", users.size() == 1);
		assertTrue("select data information error", users.get(0).getId().equals("1"));
	}
	
	@Test
	public void testcount() {
		int size =  mapper.countAll();
		assertTrue("select data number error", size == 1);
	}
	
	@Test
	public void testPage() {
		RowBounds rb = new RowBounds(0, 10);
		List<SysUser> list1 = mapper.findByPage(rb);
		assertTrue("find number error", list1.size() == 10);
		assertTrue("find data error", list1.get(0).toString().contains("id=1,name=test,password=pwd,tel=111"));
		assertTrue("find data error", list1.get(9).toString().contains("id=10,name=test10,password=pwd10,tel=101010"));
		
		RowBounds rb2 = new RowBounds(10, 10);
		List<SysUser> list2 = mapper.findByPage(rb2);
		assertTrue("find error", list2.size() == 10);
		assertTrue("find data error", list2.get(0).toString().contains("id=11,name=test11,password=pwd11,tel=111111"));
		assertTrue("find data error", list2.get(9).toString().contains("id=20,name=test20,password=pwd20,tel=202020"));
	}

}
