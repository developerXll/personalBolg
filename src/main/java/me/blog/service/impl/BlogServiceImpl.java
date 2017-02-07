package me.blog.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.blog.object.BaseService;
import me.blog.persistence.mongo.domain.Blog;
import me.blog.persistence.mongo.repository.BlogComplexRepository;
import me.blog.persistence.mongo.repository.BlogRepository;
import me.blog.service.BlogService;

@Service(BlogService.service_name)
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl extends BaseService implements BlogService {

	@Inject
	@Named("blogComplexRepository")
	private BlogComplexRepository blogComplexRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Page<Blog> findList(Pageable page) {
		return blogRepository.findAll(page);
	}

}
