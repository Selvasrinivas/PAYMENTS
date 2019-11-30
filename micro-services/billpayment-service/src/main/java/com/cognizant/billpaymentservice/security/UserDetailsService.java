package com.cognizant.billpaymentservice.security;


import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.billpaymentservice.UserAlreadyExistsException;
import com.cognizant.billpaymentservice.model.User;
import com.cognizant.billpaymentservice.model.role;
import com.cognizant.billpaymentservice.repository.UserRepository;




@Service
public class UserDetailsService {

	
	@Autowired 
	UserRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
	public UserDetailsService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Transactional
	public boolean signUp(User user) throws UserAlreadyExistsException{
		Optional<User> returnedUser = userRepository.findById(user.getUserId());	
		
		
		if(returnedUser==null)
		{
			String s=bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(s);
			
			Set<role> roleList= (Set<role>) new role();
			roleList.add(new role(2,"ROLE_USER"));
			user.setRoleList(roleList);
			
			User us=new User(0, user.getFirstName(),user.getLastName(),user.getAge(),user.getGender(),user.getContactNumber(),user.getPan(),
					user.getAadhar(), user.getUsId(), user.getPassword(),user.getRoleList());
			userRepository.save(us);	
		}
		else
		{
			throw new UserAlreadyExistsException();
		}
		
		
		return true;
		
	}
}
