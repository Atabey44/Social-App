package com.ata.socialApp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ata.socialApp.entities.Like;
import com.ata.socialApp.requests.LikeCreateRequest;
import com.ata.socialApp.service.LikeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/likes")
public class LikeController {

				private LikeService likeService;

				public LikeController(LikeService likeService) {
					super();
					this.likeService = likeService;
				}
				
				@GetMapping
				public List<Like> getAllLikes (){
					return this.likeService.getAllLikes();
				}
				
				@PostMapping
				public Like createOneLike( @RequestBody LikeCreateRequest request) {
					return this.likeService.createOneLike(request);
				}
				
				@GetMapping("/{likeId}")
				public Like getOneLike(@PathVariable Long likeId) {
					return this.likeService.getOneLikeId(likeId);
				}
				
				@DeleteMapping("/{ikeId}")
				public void deleteOneLike(Long likeId) {
				this.likeService.deleteOneLike(likeId);	
				}
}
