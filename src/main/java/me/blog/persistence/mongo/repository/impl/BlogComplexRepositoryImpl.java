package me.blog.persistence.mongo.repository.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import me.blog.persistence.mongo.domain.Blog;
import me.blog.persistence.mongo.repository.BaseComplexRepository;
import me.blog.persistence.mongo.repository.BlogComplexRepository;

@Repository(BlogComplexRepository.repositoryName)
public class BlogComplexRepositoryImpl extends BaseComplexRepository<Blog, String> implements BlogComplexRepository {
	
	public List<Blog> findByCommentUser(String user,Pageable pageable) {
		return mongoTemplate.find(new Query(Criteria.where("comments.user").is(user)).with(pageable), getDomainInstance());
	}

	@Override
	protected Class<Blog> getDomainInstance() {
		return Blog.class;
	}
}
