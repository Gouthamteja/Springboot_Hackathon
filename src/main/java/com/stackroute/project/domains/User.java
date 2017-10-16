package com.stackroute.project.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Document(collection="users")
public class User {
	
	@Id
	@ApiModelProperty(notes = "Accessible to id")
	private String id;

	@ApiModelProperty(notes = "Accessible  to specific emailid")
	private String emailid;
	
	@ApiModelProperty(notes = "Accessible  to specific username")
	private String username;
	
    //constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String id, String emailid, String username) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.username = username;
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

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

}
