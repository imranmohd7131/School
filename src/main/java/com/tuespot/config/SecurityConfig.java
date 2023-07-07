package com.tuespot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authentication
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.withUsername("Ajay")
				.password(passwordEncoder.encode("pwd1"))
				.roles("ADMIN")
				.build();

		UserDetails user = User.withUsername("Amit")
				.password(passwordEncoder.encode("pwd2"))
				.roles("NORMAL")
				.build();
		
		UserDetails us = User.withUsername("Raman")
				.password(passwordEncoder.encode("pwd3"))
				.roles("pub")
				.build();
			return new InMemoryUserDetailsManager(admin, user,us);
		//return new UserInfoService();
	}

	// authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf().disable()
				.authorizeHttpRequests().antMatchers("/role/normal").permitAll()
				.and()
				.authorizeHttpRequests().antMatchers("/role/admin").authenticated().and()
				.authorizeHttpRequests().antMatchers("/role/pub").authenticated().and()
				.formLogin().and().build();

	}

}
