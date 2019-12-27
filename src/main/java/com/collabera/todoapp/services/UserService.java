package com.collabera.todoapp.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.collabera.todoapp.model.User;

@Service
public class UserService implements UserDetailsService{
	private static List<User> users = new ArrayList<User>();
	private static int userId = 2;
	
	static {
		users.add(new User(1,"Arianne", "admin", "Hernandez", "Software Engineer"));
		users.add(new User(2,"Estela", "admin", "Hernandez", "Data Analyst"));
		users.add(new User(3,"Ariston", "admin", "Hernandez", "Mechanical Engineer"));
	}
	
	public List<User>listAllUsers(){
		return users;
	}
	// return user specific todos
	public List<User> listUsers(){	
	
		return users;
	}
	//return todo by id
	public User getUser(int userId) {
		Optional<User> tempUser= users.stream()
				.filter(user->user.getId() == userId)
				.findFirst();
				return tempUser.get();
		}	
		
	public User addUser(String userName, String password, String fullName, String roles){	
		User user = new User(userId++,password, userName, fullName, roles);
		users.add(user)	;
		return user;
	}
	 //update a todo in the list
	public User editUser(User user) {
		deleteUser(user.getId());
		users.add(user);
		return user;
		
	}
	
	//delete a todo
	public User deleteUser(int userId) {
		Optional<User> tempUser= users.stream()
				.filter(user->user.getId() == userId)
				.findFirst();
						
		if(tempUser.isPresent())
			users.remove(tempUser.get());
		
				return tempUser.get();
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user= getUserByName(username);
		
		UserBuilder userBuilder = null;
		UserDetails userDetails= null;
		
		if(user!=null) {
			userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUserName());
		    userBuilder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
		    userBuilder.roles(user.getRoles());
		    userDetails =userBuilder.build();
		    
		return userDetails;
		}
		else {
			throw new UsernameNotFoundException("User Does not Exists");
		}
		
		
	}
	private User getUserByName(String username) {
		// TODO Auto-generated method stub
		 for (User user : users) {
		      if (user.getUserName().equals(username)) {
		        return user;
		      }
		    }
		return null;
	}
}
