package com.expense;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//Main Class For starting Expense management application
@SpringBootApplication
public class ExpenseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseApplication.class, args);
	}


	 
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
