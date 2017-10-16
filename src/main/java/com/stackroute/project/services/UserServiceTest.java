package com.stackroute.project.services;

import com.stackroute.project.controller.*;
import com.stackroute.project.domains.*;
import com.stackroute.project.repository.*;
import com.stackroute.project.Application;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserServiceTest {


   private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private User user;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        userService=new UserService();
        userService.setUserrepository(userRepository);
    }
    @Test
    public void shouldReturnUser_whenGetUserByIdIsCalled() throws Exception {
        // Arrange
        when(userRepository.findOne("1")).thenReturn(user);
        // Act
        User retrievedUser = userService.getByid("1");
        // Assert
        assertThat(retrievedUser, is(equalTo(user)));

  }
    

   @Test
    public void shouldCallDeleteMethodOfUserRepository_whenDeleteUserIsCalled() throws Exception {
        // Arrange
        doNothing().when(userRepository).delete("3");
        UserRepository my = Mockito.mock(UserRepository.class);
        // Act
        userService.deleteUser("3");
        // Assert
        verify(userRepository, times(1)).delete("3");
   }
   
   @Test
   public void shouldUpdateUser_whenUpdateUserByIdIsCalled() throws Exception {
       // Arrange
       when(userRepository.save(user)).thenReturn(user);
       // Act
       User retrievedUser = userService.updateUser(user);
       // Assert
       assertThat(retrievedUser, is(equalTo(user)));

 }
   
   @Test
   public void shouldCallAddMethodOfUserRepository_whenAddUserIsCalled() throws Exception {
       // Arrange
	   when(userRepository.save(user)).thenReturn(user);
       // Act
       User retrievedUser = userService.add(user);
       // Assert
       assertThat(retrievedUser, is(equalTo(user)));
  }
   
   
   
    
}