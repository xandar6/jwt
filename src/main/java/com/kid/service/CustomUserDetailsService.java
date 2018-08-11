package com.kid.service;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kid.model.ApplicationUser;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	System.out.println("from loadUserByUsername in CustomUserDetailsService");
	ApplicationUser applicationUser = loadApplicationUserByUsername(username);
	return new User(applicationUser.getUsername(), applicationUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
    
    public ApplicationUser loadApplicationUserByUsername(String username){
	return new ApplicationUser("batman", "1234");
    }

    
}
