package com.github.amir.bootangularjsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class BootAngularjsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootAngularjsDemoApplication.class, args);
	}
	
	@Bean
	 public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource);
	    return bean;
	 }

}
