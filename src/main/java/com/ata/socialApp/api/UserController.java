package com.ata.socialApp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ata.socialApp.core.utilities.DataResult;
import com.ata.socialApp.entities.User;
import com.ata.socialApp.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

	
					private UserService userService;
			
					public UserController(UserService userService) {
						super();
						this.userService = userService;
					}
					
					@GetMapping("/getAllUsers")
					public DataResult<List<User>> getAllUsers() {
						return this.userService.getAllUsers();
					}
					
					
					@PostMapping("/saveOneUser")
					public User saveOneUser(@RequestBody User newUser){
						return this.userService.saveOneUser(newUser);
					}
					
					@GetMapping("/{userId}")
					public User getOneUser(Long userId) {
						return this.userService.getOneUserById(userId);
				}
					
					@PutMapping("/{userId}")
					public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
				
						return this.userService.updateOneUser(userId, newUser);											
					}
					
					@DeleteMapping("/{userId}")
					public  void  deleteOneUser(Long userId){
				  this.userService.deleteOneUser(userId);
					}
					
					
}
