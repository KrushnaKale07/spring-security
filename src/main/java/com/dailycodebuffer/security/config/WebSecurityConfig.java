package com.dailycodebuffer.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated()).formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails krushna = 
				User.withUsername("krushna")
				.password("{noop}password")
				.roles("USER").build();
		
		UserDetails nikhil = User
				.withUsername("nikhil")
				.password("{noop}password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(krushna, nikhil);
	}
}
