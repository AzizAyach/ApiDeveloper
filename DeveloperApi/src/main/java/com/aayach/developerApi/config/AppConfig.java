package com.aayach.developerApi.config;

import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;




@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.aayach.developerApi.repository"),
      @ComponentScan("com.aayach.developerApi.service") })
public class AppConfig {

	@Autowired
	   private Environment env;

	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

	      Properties props = new Properties();
	   
	      props.put(org.hibernate.cfg.Environment.DRIVER, env.getProperty("mysql.driver"));
	      props.put(org.hibernate.cfg.Environment.URL, env.getProperty("mysql.url"));
	      props.put(org.hibernate.cfg.Environment.USER, env.getProperty("mysql.user"));
	      props.put(org.hibernate.cfg.Environment.PASS, env.getProperty("mysql.password"));

	    
	      props.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
	      props.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

	     
	      props.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	      props.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	      props.put(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT, 
	            env.getProperty("hibernate.c3p0.acquire_increment"));
	      props.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	      props.put(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setPackagesToScan("com.aayach.developerApi.model");

	      return factoryBean;
	   }

	   @Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }	
	
}
