

package com.ata.socialApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.ata.socialApp.entities.Post;
import com.ata.socialApp.entities.User;
import com.ata.socialApp.repository.PostRepository;
import com.ata.socialApp.requests.PostCreateRequest;
import com.ata.socialApp.requests.PostUpdateRequest;

@Service
public class PostService {
		
				private PostRepository postRepository;
				private UserService userService;
				public PostService(PostRepository postRepository, UserService userService) {
					super();
					this.postRepository = postRepository;
					this.userService = userService;
				}
				
				 
				public List<Post> getAllPosts( ){
					return this.postRepository.findAll();
				}


				public Post getOnePostById(Long postId) {
					return this.postRepository.findById(postId).orElse(null);
				}


				public Post createOnePost( PostCreateRequest newPostRequest) {
					User user = userService.getOneUserById(newPostRequest.getUserId());
					if (user== null)
						return null; 				
					Post toSave = new Post();
					toSave.setId(newPostRequest.getId());
					toSave.setText(newPostRequest.getText());
					toSave.setTitle(newPostRequest.getTitle());
					toSave.setUser(user);	
					return this.postRepository.save(toSave);
				}

				
				
				public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
					Optional<Post> post = this.postRepository.findById(postId);
					if (post.isPresent()) {
						Post toUpdate = post.get();
						toUpdate.setText(updatePost.getText());
						toUpdate.setTitle(updatePost.getTitle());						
						this.postRepository.save(toUpdate);
						return toUpdate;
					}
					
					return null;
				}
				
				
				public void deleteOnePost(Long postId) {
				this.postRepository.deleteById(postId);
				}


			
				


	
		
}
