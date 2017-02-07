package me.blog.dataSource;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
// 扫描管理包的路径
@EnableMongoRepositories(basePackages = MongoDataSourceConfig.PACKAGE)
public class MongoDataSourceConfig extends AbstractMongoConfiguration {
	
	// 定义包扫描路径
	static final String PACKAGE = "me.blog.persistence.mongo.repository";
	
	@Value("${spring.datasource.mongo.database}")
	private String databaseName;
	
	@Value("${spring.datasource.mongo.username}")
	private String username;
	
	@Value("${spring.datasource.mongo.password}")
	private String password;
	
	@Value("${spring.datasource.mongo.port}")
	private String port;
	
	@Value("${spring.datasource.mongo.host}")
	private String host;
	
	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	@Bean(name = "mongodb")
	public Mongo mongo() throws Exception {
		ServerAddress serverAdress = new  ServerAddress(host, Integer.valueOf(port));        
		// MongoCredential credential = MongoCredential.createMongoCRCredential(username, databaseName , password.toCharArray());
		// mongo db版本为3.2.7 authSchema为5，此时的用户验证证书应该为ScramSha1,3.0之前的版本为Mongo-CR
		// 或者可以用非安全模式重启mongodb删除已创建的用户，然后修改admin.system.version表的authSchema为3
		MongoCredential credential = MongoCredential.createScramSha1Credential(username, databaseName, password.toCharArray());
		Mongo mongo =  new MongoClient(serverAdress, Arrays.asList(credential));
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}
	
	@Override
	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}
