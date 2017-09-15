package com.cdut;

import com.cdut.common.repository.CommonRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.Filter;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.cdut", repositoryFactoryBeanClass = CommonRepositoryFactoryBean.class)
@ComponentScan(basePackages = "com.cdut")
@EnableScheduling
@EntityScan(basePackages = "com.cdut")
@EnableTransactionManagement
public class ManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ManagerApplication.class, args);
	}

	@Bean
	public Filter openEntityManagerInViewFilter() {

		return new OpenEntityManagerInViewFilter();
	}
}
