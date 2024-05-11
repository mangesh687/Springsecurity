package com.springsecurity.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MYconfiger  {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser=User.withUsername("normal")
				.password(passwordEncoder().encode("normal"))
				//.password("normal")
				.roles("NORMAL")
				.build();
		
		
		UserDetails adminUser=User.withUsername("admin")
				//.password("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(normalUser,adminUser);
		
		
	}
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
	.authorizeRequests()
	//.requestMatchers("/admin").hasRole("ADMIN")
//		.requestMatchers("/normal").hasRole("NORMAL")
//		.requestMatchers("/public").permitAll()
		.anyRequest()
		.authenticated()
		.and().formLogin();
		return http.build();
	}
	
	
	
	

}
