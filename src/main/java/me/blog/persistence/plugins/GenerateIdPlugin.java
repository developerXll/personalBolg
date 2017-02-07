package me.blog.persistence.plugins;

import java.lang.reflect.Field;
import java.util.Properties;
import java.util.UUID;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
/**
 * 
 * @author Administrator
 * 自动生成id插件
 * 弃用
 *
 */
@Intercepts({@Signature(type = Executor.class, method="update",
		args={MappedStatement.class, Object.class})})
public class GenerateIdPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
		// insert
		if(SqlCommandType.INSERT.equals(ms.getSqlCommandType()) && invocation.getArgs().length > 1) {
			Object parameter = invocation.getArgs()[1];
			Field idField = parameter.getClass().getDeclaredField("id");
			if(idField != null 
					&& idField.getGenericType().getTypeName().equals("java.lang.String")) {
				idField.setAccessible(true);
				Object value = idField.get(parameter);
				if(value == null || value.toString().length() <= 0) {
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					idField.set(parameter, uuid);
				}
			}
		}
		// continue operation executive
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}

}
