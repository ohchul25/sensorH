package com.sensor.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(value="com.sensor")
public class MybatisConfig {

/*
	@Bean
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
	  SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource);

	  Resource[] res=new PathMatchingResourcePatternResolver()
	       .getResources("classpath:/mappers/*_SQL.xml");

	  //sessionFactory.setEnvironment("dev");

	  Properties properties = new Properties();
	  properties.put("mapUnderscoreToCamelCase", true);
	  properties.put("jdbcTypeForNull", "VARCHAR");
	  properties.put("callSettersOnNulls", "true");
	  sessionFactory.setConfigurationProperties(properties);

	  sessionFactory.setMapperLocations(res);
	  sessionFactory.setTypeAliasesPackage("org.prj.arachne.domain");
	  sessionFactory.setTypeAliases(null)
	  sessionFactory.setTypeHandlers(new TypeHandler[] {
	    new DateTypeHandler(),
	    new BooleanTypeHandler()
	  });

	  return sessionFactory.getObject();
	 }

*/
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/**/*_SQL.xml"));

	    Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml");
	    sessionFactory.setConfigLocation(myBatisConfig);

	    return sessionFactory.getObject();
	  }

   /**
     * 마이바티스 {@link org.apache.ibatis.session.SqlSession} 빈을 등록한다.
     *
     * SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다.
     * 쓰레드에 안전하게 작성되었기 때문에 여러 DAO나 매퍼에서 공유 할 수 있다.
     */
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}