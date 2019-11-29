package com.cognizant.BillPaymentSystem.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.cognizant.BillPaymentSystem.UserAlreadyExistsException;
import com.cognizant.BillPaymentSystem.Model.User;
import com.cognizant.BillPaymentSystem.Model.role;
import com.cognizant.BillPaymentSystem.Repository.UserRepository;


@Service
public class UserService {
 @Autowired
 UserRepository userRepository;
 BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
 @Transactional
  public void updateUserDetails(User user){
	 Optional<User> result= userRepository.findById(user.getUserId());
 userRepository.save(user);	 
  }
  @Transactional
  public List<User> getUserList(){
    return userRepository.findAll();		 
	 }

  @Transactional
  public User addUser(@Valid User user,int rol) throws UserAlreadyExistsException
  {
	  
	Optional<User>  newUser = userRepository.findByname(user.getUsId());
	User newuser1;
	if(newUser.isPresent())
	{
		throw new UserAlreadyExistsException();
	}
	else{
		
	
	   BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
	   
	   user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	   
	   Set<role> roles = new HashSet<role>();
	  

	   role assignRole;
	   if(rol == 1)
	   {
	        assignRole = new role(1, "ROLE_ADMIN");
	        roles.add(assignRole);
	   }
	   if(rol ==2 )
	   {
	        assignRole = new role(2, "ROLE_USER");
	        roles.add(assignRole);
	   }
	   
	   

	   newuser1 = new User(0,user.getFirstName(),user.getLastName(),user.getAge(),user.getGender(),user.getContactNumber(),user.getPan(),user.getAadhar(),user.getUsId(),user.getPassword(),roles);

	}

	 return userRepository.save(newuser1);
	 
	  
  }
public Optional<User> getUser(int userId) {
	// TODO Auto-generated method stub
	return userRepository.findById(userId);
}

  
 
}






