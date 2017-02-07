package me.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.blog.persistence.mongo.domain.Blog;

public interface BlogService {
	String service_name = "blogService";
	
	Page<Blog> findList(Pageable page);
}
