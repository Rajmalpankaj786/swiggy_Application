package com.swiggy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain swiggySecurityconfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/customer/customers").authenticated()
				.requestMatchers("/customer/customers/{pageNo}/{recordPerPage}")
				.permitAll()
				)
				.csrf(csrf -> csrf
						.disable()
						)
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		
		        return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		
		UserDetails admin= User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1234")
					.authorities("admin")
					.build();
		
		UserDetails user= User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.authorities("read")
				.build();

		return new InMemoryUserDetailsManager(admin,user);
		
	}
}
