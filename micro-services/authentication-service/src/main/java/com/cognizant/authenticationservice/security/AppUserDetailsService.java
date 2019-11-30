package com.cognizant.authenticationservice.security;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;





@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	//@Autowired
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//System.err.println("**************************************username : " + username);
		/*if(username==null)
			username="default";
		*/User user = userRepository.findByIdName(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found !");
		
		
		return new AppUser(user);
	}

	
	
	
}
