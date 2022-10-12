package com.ata.socialApp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ata.socialApp.entities.Like;
import com.ata.socialApp.entities.Post;
import com.ata.socialApp.entities.User;
import com.ata.socialApp.repository.LikeRepository;
import com.ata.socialApp.requests.LikeCreateRequest;

@Service
public class LikeService {

				private LikeRepository likeRepository;
				private UserService userService;
				private PostService postService;
										
				public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
					super();
					this.likeRepository = likeRepository;
					this.userService = userService;
					this.postService = postService;
				}

				public List<Like> getAllLikes() {
  				    return this.likeRepository.findAll();
				}

				public Like createOneLike(LikeCreateRequest request) {
					User user = userService.getOneUserById(request.getUserId());
					Post post = postService.getOnePostById(request.getPostId());
					if (user != null && post !=null ) {
						Like toSaveLike = new Like();
						toSaveLike.setId(request.getId());
						toSaveLike.setUser(user);
						toSaveLike.setPost(post);
						return this.likeRepository.save(toSaveLike);
				} else{
					return null;
				}
				
				}

				public Like getOneLikeId(Long likeId) {
				return this.likeRepository.findById(likeId).orElse(null);
				}

				public void deleteOneLike(Long likeId) {
				this.likeRepository.deleteById(likeId);
				}
								

}
