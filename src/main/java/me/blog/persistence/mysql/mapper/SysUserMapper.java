package me.blog.persistence.mysql.mapper;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;

import me.blog.persistence.mysql.domain.SysUser;

@Mapper
public interface SysUserMapper {
	@Insert("insert into `sys_user` (ID, NAME, PASSWORD, TEL) values(#{id}, #{name}, #{password}, #{tel})")
	// 自动赋值id, 同时将id值赋予sysUser
	@SelectKey(statement="SELECT REPLACE(UUID(),'-','') FROM DUAL", keyProperty="id", before=true, resultType=String.class)
	void insert(SysUser user);
	
	@Delete("delete from user where ID = #{id}")
	void delete(String id);
	
	@Select("select * from `sys_user` where ID = #{id}")
	SysUser load(String id);
	
	@UpdateProvider(type = UserUpdateSqlBuilder.class, method = "buildUpdateSql")
	void update(SysUser user);
	
	@Select("select count(ID) from `sys_user`")
	int countAll();

	@Select("select * from `sys_user`")
	List<SysUser> findAll();
	
	@Select("select * from `sys_user`")
	List<SysUser> findByPage(RowBounds rowBounds);
	
	@Select("select * from `sys_user` where NAME = #{name}")
	SysUser findUserByName(String name);
	
	class UserUpdateSqlBuilder {
		public String buildUpdateSql(SysUser user) {
			if(user == null || StringUtils.isBlank(user.getId())) return "";
			return new SQL(){{
				UPDATE("`sys_user`");
				if(user.getName() != null) {
					SET("NAME = #{name}");
				}
				if(user.getPassword() != null) {
					SET("PASSWORD = #{password}");
				}
				if(user.getTel() != null) {
					SET("TEL = #{tel}");
				}
				WHERE("ID = #{id}");
			}}.toString();
		}
	}

}
