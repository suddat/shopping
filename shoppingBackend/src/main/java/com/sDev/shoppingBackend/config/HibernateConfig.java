package com.sDev.shoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.sDev.shoppingBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Can be changed below configuration on basis of preferred DBMS
	private final static String DATABASE_URL 	  = "jdbc:h2:tcp://localhost/~/shopping";
	private final static String DATABASE_DRIVER   = "org.h2.Driver";
	private final static String DATABASE_DIALECT  = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//Database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	//Below Session Factory
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.sDev.shoppingBackend.dto");
		return builder.buildSessionFactory();
	}
	
	//Hibernate properties will be returned by this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", DATABASE_DIALECT);
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");		
		return properties;
	}
	@Bean
	public HibernateTransactionManager  getTransactionManager(SessionFactory sessioinFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessioinFactory);
		return transactionManager;
	}
}
