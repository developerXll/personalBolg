package me.blog.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.blog.object.BaseController;
import me.blog.persistence.mongo.domain.Blog;
import me.blog.persistence.mongo.repository.BlogComplexRepository;
import me.blog.persistence.mongo.repository.BlogRepository;

@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {
	
	@Inject
	@Named("blogComplexRepository")
	private BlogComplexRepository blogComplexRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<Page<Blog>> getList(Pageable pageable) {
		Page<Blog> blogs = blogRepository.findAll(pageable);
		return new ResponseEntity<Page<Blog>>(blogs, HttpStatus.OK);
	}
}
