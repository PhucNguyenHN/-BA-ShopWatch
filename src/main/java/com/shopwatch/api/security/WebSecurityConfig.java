package com.shopwatch.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shopwatch.api.security.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/v1/api/bill/*").hasRole("ADMIN")
				.antMatchers("/v1/api/user/*").hasAnyRole("CUSTOMER","ADMIN")
				.antMatchers("/v1/api/register", "/v1/api/login","/v1/api/user", "/v1/api/cart", "/v1/api/cart/*", "/v1/api/brand", "/v1/api/brand/*",
						"/v1/api/type", "/v1/api/type/*", "/v1/api/color", "/v1/api/color/*", "/v1/api/gender", "/v1/api/gender/*",
						"/v1/api/payment","/v1/api/payment/*", "/v1/api/product", "/v1/api/product/*","/v1/api/bill").permitAll()
				.anyRequest().authenticated()

				.and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling();

		http.csrf().disable().cors().and();
	}
}
