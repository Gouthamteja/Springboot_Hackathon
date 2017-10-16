package com.stackroute.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.project.domains.User;
import com.stackroute.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;


	
	
	public UserRepository getUserrepository() {
		return userrepository;
	}

	public void setUserrepository(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	public User add(User user) {
		
		userrepository.save(user);
		return user;
	}
	
	public User getByid(String id){
		
		User user =userrepository.findOne(id);
		return user;
		
	}
	
	public User updateUser(User user) {
		userrepository.save(user);
		return user;
	}
	
	public void deleteUser(String id) {
		userrepository.delete(id);
	}
	
	public List<User> getAll(){
		List<User> users=new ArrayList<>();
		userrepository.findAll().forEach(users::add);
		return users;
	}

}
