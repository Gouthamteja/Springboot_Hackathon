package com.stackroute.project.controller;


import com.stackroute.project.*;
import com.stackroute.project.domains.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    User user;
    @Before
    public void setUp() throws Exception {
         user = new User("3","mail","Paul Dawson");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveUser() throws Exception {
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/goUser/adduser"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User saved successfully",actual);
    }

   @Test
    public void testdelete() throws Exception {
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/goUser/delete/3"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Deleted succesfully",actual);
    }  
   @Test
    public void testupdate() throws Exception {
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/goUser/updateuser"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User updated successfully",actual);
    }
    
   
   @Test
    public void testEGetUserByExistingId() throws Exception {
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<User> response = restTemplate.exchange(
                createURLWithPort("/goUser/show/3"),
                HttpMethod.GET, entity, User.class);
        
      assertNotNull("Expected some value but found null",response);
        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
   }
    
//    @Test
//    public void testEGetUsers() throws Exception {
//        List<User> users= new ArrayList();
//        users.add(user);
//        HttpEntity<List<User>> entity = new HttpEntity<List<User>>(users, headers);
//        ResponseEntity<User> response = restTemplate.exchange(
//                createURLWithPort("/goUser/list"),
//                HttpMethod.GET, entity, User.class);
//        
//       assertNotNull("Expected some value but found null",response);
//        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
//    }
    
   

}