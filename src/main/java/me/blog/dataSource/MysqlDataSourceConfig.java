package me.blog.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
// 扫描管理包的路径
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSessionFactory")
// restful JPA 资源配置 
@EnableJpaRepositories(basePackages=MysqlDataSourceConfig.JPAPACKAGE, transactionManagerRef="mysqlTransactionManager")
public class MysqlDataSourceConfig {
	
	// 定义包扫描路径
	static final String PACKAGE = "me.blog.persistence.mysql.mapper";
	static final String JPAPACKAGE = "me.blog.repositoryRest";
	
	
	@Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource")DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }
	
	@Bean(name = "mysqlSessionFactory")
	@Primary
	public SqlSessionFactory mysqlSessionFactory(@Qualifier("mysqlDataSource")DataSource mysqlDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource);
        return sessionFactory.getObject();
	}

}
