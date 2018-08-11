package com.kid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.kid.service.CustomUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
	this.customUserDetailsService = customUserDetailsService;
	System.out.println("from SecurityConfig constructor");
	System.out.println(this.customUserDetailsService.loadUserByUsername("df").getUsername());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
	System.out.println("from configure");
	http.cors().and().csrf().disable().authorizeRequests()
	.antMatchers(HttpMethod.POST, "/sign_up").permitAll()
	.antMatchers("/*/floor1/**").hasRole("USER")
	.antMatchers("/*/floor2/**").hasRole("ADMIN")
	.antMatchers("/employee/**").hasRole("USER")
	.antMatchers("/driver/**").hasRole("USER")
	.antMatchers("/item/**").hasRole("USER")
	.antMatchers("/combo_item/**").hasRole("USER")
	.antMatchers("/customer/**").hasRole("USER")
	.and()
	.addFilter(new JwtAuthenticationFilter(authenticationManager()))
	.addFilter(new JwtAuthorizationFilter(authenticationManager(), customUserDetailsService));
    }

    
}
