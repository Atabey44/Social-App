package com.ata.socialApp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.ata.socialApp.entities.Comment;
import com.ata.socialApp.entities.Post;
import com.ata.socialApp.entities.User;
import com.ata.socialApp.repository.CommentRepository;
import com.ata.socialApp.requests.CommentCreateRequest;
import com.ata.socialApp.requests.CommentUpdateRequest;


@Service
public class CommentService {

			private CommentRepository commentRepository;
			private UserService userService;
			private PostService postService;
			
			public CommentService(CommentRepository commentRepository, UserService userService,
					PostService postService) {
				super();
				this.commentRepository = commentRepository;
				this.userService = userService;
				this.postService = postService;
			}

			public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
			if (userId.isPresent() && postId.isPresent()) {
				return this.commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
			} else if (userId.isPresent()) {
				return this.commentRepository.findByUserId(userId.get());
			} else if (postId.isPresent()) {
				return this.commentRepository.findByPostId(postId.get());
			}
				return this.commentRepository.findAll();
			}

			public Optional<Comment> getOneCommentById(Long commentId) {
				return this.commentRepository.findById(commentId);
			}

			public Comment createOneComment(CommentCreateRequest request) {
				User user = userService.getOneUserById(request.getUserId());
				Post post = postService.getOnePostById(request.getPostId());
				if (user!= null && post != null) {
					Comment commentToSave = new Comment();
					commentToSave.setId(request.getId());
					commentToSave.setPost(post);
					commentToSave.setUser(user);
					commentToSave.setText(request.getText());
					return this.commentRepository.save(commentToSave);
					
				} else
				return null;
			}

			public Comment updateOneComment(Long commentId,   CommentUpdateRequest request) {
			Optional<Comment> comment = commentRepository.findById(commentId);
			if (comment.isPresent()) {
				Comment commentToUpdate = comment.get();
				commentToUpdate.setText(request.getText());
				this.commentRepository.save(commentToUpdate);
				return commentToUpdate;
			}
			
				return null;
			}

			public void deleteOneCommentById(Long commentId) {
			this.commentRepository.deleteById(commentId);	
			}
			
		

}
