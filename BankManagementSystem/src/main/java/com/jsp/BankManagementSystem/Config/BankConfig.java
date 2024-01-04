package com.jsp.BankManagementSystem.Config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.jsp.BankManagementSystem")
@EnableJpaRepositories(basePackages = "com.jsp.BankManagementSystem")
public class BankConfig {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("BankManagementSystem");
		return bean;
	}
	
	@Bean
	public  JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager  = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}
