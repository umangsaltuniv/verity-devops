package com.expense.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.expense.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	//DAO based user authentication
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	//Security configuration
	@Override
	public void configure(HttpSecurity http) throws Exception {

		
		 String[] resources = new String[]{
	                "/pictureCheckCode","/include/**",
	                "/css/**","/icons/**","/images/**","/js/**","/layer/**"
	        };


		http
		.antMatcher("/**")
		.authorizeRequests()
		.antMatchers(resources).permitAll()
		.antMatchers("/add-user").permitAll()
		.antMatchers("/login.jsp").permitAll()
		.anyRequest()
        .authenticated()
		.and().formLogin()
				.loginPage("/login.jsp").failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
				.defaultSuccessUrl("/expense-home", true).permitAll()
				.and().logout()
				.logoutUrl("/appLogout")
				.logoutSuccessUrl("/login.jsp?logout");


	}

}