package com.stackroute.project.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Document(collection="user")
public class User {
	
	@Id
	@ApiModelProperty(notes = "Accessible to user password")
	private String emailid;
	
	@ApiModelProperty(notes = "Accessible  to specific user")
	private String username;
	
	
	
	
    //constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String emailid) {
		super();
		this.username = username;
		this.emailid = emailid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	
	

}
