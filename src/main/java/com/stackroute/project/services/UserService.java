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
	
	
	public Boolean add(User user) {
		
		if(user.getEmailid()==null || user.getEmailid()=="" || user.getUsername()==null || user.getUsername()=="") {
			return false;
		}
		
		userrepository.save(user);
		return true;
	}
	
	public User getByEmailid(String emailid){
		
		User user =userrepository.findOne(emailid);
		return user;
		
	}
	
	public Boolean updateUser(User user) {
		userrepository.save(user);
		return true;
	}
	
	public void deleteUser(String emailid) {
		userrepository.delete(emailid);
	}
	
	public List<User> getAll(){
		List<User> users=new ArrayList<>();
		userrepository.findAll().forEach(users::add);
		return users;
	}

}
