package com.ata.socialApp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ata.socialApp.entities.Post;
import com.ata.socialApp.requests.PostCreateRequest;
import com.ata.socialApp.requests.PostUpdateRequest;
import com.ata.socialApp.service.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/posts")
public class PostController {

	
			private PostService postService;

			public PostController(PostService postService) {
				super();
				this.postService = postService;
			}
			
			@GetMapping
			public List<Post> getAllPosts( ){
				return this.postService.getAllPosts();
			}
			 
			@GetMapping("/{postId}")
			public Post getOnePost(@PathVariable Long postId) {
				return this.postService.getOnePostById(postId);
			}
			
			@PostMapping
			public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
				return this.postService.createOnePost(newPostRequest);
			}
			
			@PutMapping("/{postId}")
			public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
				return this.postService.updateOnePost(postId, updatePost);
			}
			
			@DeleteMapping("/{postId}")
			public void deleteOnePost(Long postId) {
				this.postService.deleteOnePost(postId);
			}
			
			
			
			
			
}
