package com.ata.socialApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ata.socialApp.core.utilities.DataResult;
import com.ata.socialApp.core.utilities.SuccessDataResult;
import com.ata.socialApp.entities.User;
import com.ata.socialApp.repository.UserRepository;

@Service
public class UserService {

				private UserRepository userRepository;
			
				public UserService(UserRepository userRepository) {
					super();
					this.userRepository = userRepository;
				}
				
			public DataResult<List<User>> getAllUsers() {
				return new SuccessDataResult<List<User>>
				(this.userRepository.findAll(),"Data Başarıyla Listelendi");
			}
			
			public User saveOneUser(User newUser){
				return this.userRepository.save(newUser);
			}
			
			
			public User getOneUserById(Long userId) {
				return this.userRepository.findById(userId).orElse(null);
			}
			
			public User updateOneUser(Long userId, User newUser ) {
				Optional<User> user = userRepository.findById(userId);
				if(user.isPresent()) {
					User foundUser = user.get();
					foundUser.setUserName(newUser.getUserName());
					foundUser.setPassword(newUser.getPassword());
					userRepository.save(foundUser);
					return foundUser;
				}
				return null;
			}
			
			public void deleteOneUser( Long userId) {
				 this.userRepository.deleteById(userId);
			}
			
			
			
			
			
			
}
