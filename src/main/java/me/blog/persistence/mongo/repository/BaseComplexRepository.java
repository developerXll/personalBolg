package me.blog.persistence.mongo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import me.blog.persistence.mongo.repository.BaseComplexRepository;

public abstract class BaseComplexRepository<T, ID extends Serializable> {
	
	@Autowired
	@Qualifier("mongoTemplate")
	protected MongoTemplate mongoTemplate;
	
	protected abstract Class<T> getDomainInstance();
	
	public List<T> find(Query query) {
		return getDomainInstance() != null ? mongoTemplate.find(query, getDomainInstance()) : null;
	}
	
}
