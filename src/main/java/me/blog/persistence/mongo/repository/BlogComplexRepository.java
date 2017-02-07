package me.blog.persistence.mongo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;

import me.blog.persistence.mongo.domain.Blog;

/**
 * complex repository
 * @author Administrator
 * @param <T>
 *
 */
public interface BlogComplexRepository {
	static String repositoryName = "blogComplexRepository";
	
	public List<Blog> findByCommentUser(String user, Pageable pageable);
	
	public List<Blog> find(Query query);

}
