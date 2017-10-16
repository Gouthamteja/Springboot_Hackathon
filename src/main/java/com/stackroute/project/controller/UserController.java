package com.stackroute.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.project.domains.User;
import com.stackroute.project.services.UserService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/goUser")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping(value="/list", produces= {"application/json"})
	public ResponseEntity<List<User>> list(){
		List<User> User=new ArrayList<>();
		User=userservice.getAll();
		return new ResponseEntity<List<User>>(User,HttpStatus.OK);
	}
	
	@PostMapping(value="/adduser",consumes= {"application/json"})
	public ResponseEntity<String> useradd(@RequestBody User user){
		Boolean b=userservice.add(user);
		if(b) {
		return new ResponseEntity<String>("user added",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not valemailid user",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/updateuser",consumes= {"application/json"})
	public ResponseEntity<String> userupdate(@RequestBody User user){
		Boolean b=userservice.updateUser(user);
		if(b) {
		return new ResponseEntity<String>("updated user",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not updated user",HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value="/show/{emailid}", produces= {"application/json"})
	@ApiOperation(value = "Search a product with an emailid",response = User.class)
	public ResponseEntity<User> getone(@RequestBody String emailid){
		User place=userservice.getByEmailid(emailid);
		return new ResponseEntity<User>(place,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a product")
	@DeleteMapping(value="/delete/{emailid}")
	  public ResponseEntity<String> delete(@RequestBody String emailid){
		userservice.deleteUser(emailid);
		return new ResponseEntity<String>("Deleted Succesfully",HttpStatus.OK);
	}

}
