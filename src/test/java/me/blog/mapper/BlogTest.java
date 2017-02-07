package me.blog.mapper;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;

import me.blog.PersonalBlogApp;
import me.blog.persistence.mongo.domain.Blog;
import me.blog.persistence.mongo.domain.Comment;
import me.blog.persistence.mongo.domain.QBlog;
import me.blog.persistence.mongo.repository.BlogComplexRepository;
import me.blog.persistence.mongo.repository.BlogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PersonalBlogApp.class)
public class BlogTest {
	
	@Autowired
	private BlogRepository repository;
	@Autowired
	private BlogComplexRepository blogComplexRepository;
	
	@Test
	public void testInsert() {
		Blog blog = new Blog();
		blog.setTitle("如何成为一个优秀的程序猿？");
		blog.setContent("只需要好好学习即可！");
		blog.setInsertDate(new Date());
		Comment c1 = new Comment();
		c1.setUser("骑着猪的男人");
		c1.setContent("说得好");
		c1.setInsertDate(new Date());
		Comment c2 = new Comment();
		c2.setUser("Las丶Vgas");
		c2.setContent("纯属胡扯");
		c2.setInsertDate(new Date());
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(c1);
		comments.add(c2);
		blog.setComments(comments);
		Blog afterBlog = repository.insert(blog);
		System.out.println("before insert.........");
		System.out.println(blog);
		System.out.println("after insert.........");
		System.out.println(afterBlog);
		List<Blog> titleFoundBlog = repository.findByTitle("如何成为一个优秀的程序猿？");
		System.out.println("found by title blog.........");
		for(Blog b : titleFoundBlog) {
			System.out.println(b);
		}
		/*List<Blog> commentsUserNames = mapper.findByCommontsUser("骑着猪的男人");
		System.out.println("found by comment user blog.........");
		for(Blog b : commentsUserNames) {
			System.out.println(b);
		}*/
	}
	
	@Test
	public void testLoad() {
		List<Blog> blogs = blogComplexRepository.findByCommentUser("Las丶Vgas", new PageRequest(1, 5));
		assertTrue("get findByCommentUser data error", blogs != null);
		System.out.println("=============findByCommentUser Method data==================");
		for(Blog blog : blogs) {
			System.out.println(blog);
		}
		blogs = blogComplexRepository.find(new Query(Criteria.where("title").is("如何成为一个优秀的程序猿？")));
		assertTrue("get abstract method find data error", blogs != null);
		System.out.println("=============find Method data==================");
		try(Stream<Blog> stream = blogs.parallelStream()){
			stream.forEach(System.out::println);
		}
	}
	
	@Test
	public void testStream() {
		Date date = new Date();
		try(Stream<Blog> blogs = repository.findAllByInsertDate(date)) {
			blogs.filter(b -> b.getInsertDate().compareTo(date) > 0)
			.map(Blog::getTitle)
			.map(String::toUpperCase)
			.collect(Collectors.joining());
		}
		
		// queryDsl
		QBlog blog = QBlog.blog;
		Predicate predicate = blog.title.like("");
		OrderSpecifier<Date> order1 = blog.insertDate.asc();
		OrderSpecifier<Date> order2 = blog.updateDate.desc();
		Iterable<Blog> qblogs = repository.findAll(predicate, order1, order2);
		try(Stream<Blog> stream = StreamSupport.stream(qblogs.spliterator(), false)) {
			stream.forEach(System.out::println);
		}
	}
	
	@Test
	public void testStream1() {
		try(Stream<Map<String, Integer>> stream = Stream.of(
				Collections.singletonMap("test1", 1),
				Collections.singletonMap("test2", 2),
				Collections.singletonMap("test3", 3)
				)) {
			stream.flatMap(childMap -> childMap.values().stream())
			.forEach(System.out::println);
		}
	}

}
