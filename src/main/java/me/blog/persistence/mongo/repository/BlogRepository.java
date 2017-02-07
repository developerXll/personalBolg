package me.blog.persistence.mongo.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import me.blog.persistence.mongo.domain.Blog;

/**
 * simple repository
 * QueryDslPredicateExecutor: 可以使用QueryDsl查询
 * @author Administrator
 *
 */
public interface BlogRepository extends MongoRepository<Blog, String>, QueryDslPredicateExecutor<Blog> {
		
	List<Blog> findByTitle(String title);
	
	Stream<Blog> findAllByInsertDate(Date insertDate);
	
}
