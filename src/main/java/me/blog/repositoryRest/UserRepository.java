package me.blog.repositoryRest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import me.blog.persistence.domain.respository.SysUser;

/**
 * 
 * @author Administrator
 * 需要配合jpa使用
 * 
 * 路径为 http://localhost:8080/{spring.data.rest.base-path}/user
 * 默认为查询，方法查询为 /{spring.data.rest.base-path}/user/search/{方法名,例如 findByName}?name={参数}
 * 添加参数 POST 为新增一条记录
 * 添加参数 PUT 为替换一条记录
 * 添加参数 PATCH 为修改一条记录
 * 添加参数 DELETE 为删除一条记录
 * e.g : curl -X PUT -H "Content-Type:application/json" -d '{ "name": "Bilbo", "tel": "137" }' http://localhost:8080/api/user/0
 * curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Frodo",  "tel" : "345" }' http://localhost:8080/api/user
 * -i ensures you can see the response message including the headers
 * reference: http://spring.io/guides/gs/accessing-data-rest/
 *  
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface UserRepository extends PagingAndSortingRepository<SysUser, String> {
	
	Page<SysUser> findByName(@Param("name") String name, Pageable pageable);

}
