package me.blog;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 * 可配置多数据源
 * @author Administrator
 *
 */
@Configuration
public class DataSourceConfig {
	
	@Bean(name = "mysqlDataSource")
	@Qualifier("mysqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	@Primary
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
