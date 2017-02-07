package me.blog;

import java.util.EnumSet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.DispatcherType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import me.blog.filter.EncodingFilter;
import me.blog.interceptor.LoggerInterceptor;
import me.blog.persistence.mongo.domain.Blog;
import me.blog.persistence.mongo.repository.BlogComplexRepository;
import me.blog.persistence.mongo.repository.BlogRepository;

@SpringBootApplication
@Controller
public class PersonalBlogApp extends WebMvcConfigurerAdapter {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalBlogApp.class, args);
	}
	
	// 过滤器
	@Bean
	public FilterRegistrationBean encodingFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new EncodingFilter());
		registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}
	
	// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/blog/*");
	}
	
	@Inject
	@Named("blogComplexRepository")
	private BlogComplexRepository blogComplexRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@RequestMapping("/")
	public String index(Model model, Pageable pageAble){
		Page<Blog> page = blogRepository.findAll(pageAble);
		model.addAttribute("page", page);
		return "index";
	}
}
