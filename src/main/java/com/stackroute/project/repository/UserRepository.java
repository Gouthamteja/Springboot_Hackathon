package com.stackroute.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.stackroute.project.domains.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	

}

