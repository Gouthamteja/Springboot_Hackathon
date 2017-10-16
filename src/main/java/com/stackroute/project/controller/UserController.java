package com.stackroute.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.project.domains.User;
import com.stackroute.project.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value="/goUser")
@Api(value="users", description="Operations pertaining to User")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@ApiOperation(value = "View a list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping(value="/list", produces= {"application/json"})
	public ResponseEntity<List<User>> list(){
		List<User> User=new ArrayList<>();
		
		User=userservice.getAll();
		return new ResponseEntity<List<User>>(User,HttpStatus.OK);
	}
	
	
	@PostMapping(value="/adduser",consumes= {"application/json"})
	@ApiOperation(value = "Add a user")
	public ResponseEntity<String> useradd(@RequestBody User user){
        User usera=userservice.updateUser(user);
		
		if(usera.equals(user)) {
		return new ResponseEntity<String>("User saved successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not valid id user",HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updateuser",consumes= {"application/json"})
	@ApiOperation(value = "Update a user")
	public ResponseEntity<String> userupdate(@RequestBody User user){
		User usera=userservice.updateUser(user);
		
		if(usera.equals(user)) {
		return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not updated user",HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value="/show/{id}", produces= {"application/json"})
	@ApiOperation(value = "Search a user with an ID",response = User.class)
	public ResponseEntity<User> getone(@PathVariable("id")  String id){
		
		User user=userservice.getByid(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Delete a user")
	@DeleteMapping(value="/delete/{id}", consumes="application/json")
	  public ResponseEntity<String> delete(@PathVariable("id")  String id){
		userservice.deleteUser(id);
		return new ResponseEntity<String>("Deleted succesfully",HttpStatus.OK);
	}

}
