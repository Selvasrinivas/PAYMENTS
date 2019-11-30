 package com.cognizant.authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.security.JwtAuthorizationFilter;







@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger=LoggerFactory.getLogger(SecurityConfig.class); 
	
	@Autowired 
	AppUserDetailsService appUserDetailsService ;
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
//            .and()
//            .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
//        
		
		
       // auth.userDetailsService(inMemoryUserDetailsManager());
		
		
		
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	logger.info("Start");
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().httpBasic().and()
//            .authorizeRequests().antMatchers("/employeeall").hasRole("USER")
//            .antMatchers("/employeeall").hasRole("USER")
//            .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN");  
//    }
//    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.cors();
    	

//    	httpSecurity.csrf().disable().httpBasic().and()
//    	.authorizeRequests()
//    	.antMatchers("/user").permitAll()
//    	.anyRequest();
    	
    	httpSecurity.csrf().disable().httpBasic().and()
    	.authorizeRequests()
    	.antMatchers("/user/**").permitAll().antMatchers("/vendor/**").permitAll().antMatchers("/bill/**").permitAll().antMatchers("/bills").hasAnyRole("USER","ADMIN","SUPER").antMatchers("/authenticate").hasAnyRole("USER","ADMIN","SUPER")
    	.anyRequest().authenticated()
    	.and()
    	.addFilter(new JwtAuthorizationFilter(authenticationManager()));
    	
    	
    	/*httpSecurity.csrf().disable().httpBasic().and()
    	.authorizeRequests()
    	.antMatchers("/menu-items").hasAnyRole("USER","ADMIN")
    	.anyRequest().authenticated()
    	.and()
    	.addFilter(new JwtAuthorizationFilter(authenticationManager()));*/
    	
    	
    }
    
/*    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    	logger.info("Start");
    List<UserDetails> userDetailsList = new ArrayList<>();
    userDetailsList.add(
    User.withUsername("user")
    .password(passwordEncoder()
    .encode("pwd"))
    .roles("USER").build());
    userDetailsList.add(
    User.withUsername("admin")
    .password(passwordEncoder()
    .encode("pwd"))
    .roles("ADMIN").build());
    userDetailsList.add(
            User.withUsername("default")
                .password(passwordEncoder()
                .encode("pwd"))
                .roles("DEFAULT").build());

    System.out.println("--new user ====>"+userDetailsList.toString());
    logger.info("End");
    return new InMemoryUserDetailsManager(userDetailsList);
    }*/
    
}
