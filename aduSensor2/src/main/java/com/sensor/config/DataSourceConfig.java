package com.sensor.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	/**
     * 데이터소스 등록
	 * @return
	 */
	@Bean(destroyMethod="close")
	public DataSource dataSource() throws NamingException{
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = jndiTemplate.lookup("java:comp/env/jdbc/SEN", DataSource.class);
		return dataSource;
	}

	/**
	 * 트랜잭션 매니저 등록
	 * @return
	 * @throws NamingException
	 */
    @Bean
    public DataSourceTransactionManager transactionManager() throws NamingException {
        return new DataSourceTransactionManager(dataSource());

    }

}
