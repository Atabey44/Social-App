package com.ata.socialApp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ata.socialApp.entities.Comment;
import com.ata.socialApp.requests.CommentCreateRequest;
import com.ata.socialApp.requests.CommentUpdateRequest;
import com.ata.socialApp.service.CommentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
			private CommentService commentService;

			public CommentController(CommentService commentService) {
				super();
				this.commentService = commentService;
			}
			
			@GetMapping
			public List<Comment> getAllComments
			(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
				return this.commentService.getAllCommentsWithParam(userId, postId);
			}

			@GetMapping("/{commentId}")
			public Optional<Comment> getOneComment(@PathVariable Long commentId) {
				return this.commentService.getOneCommentById(commentId);
			}
			
			
			@PostMapping("/createOneComment")
			public Comment createOneComment(@RequestBody  CommentCreateRequest request) {
				return this.commentService.createOneComment(request);
			}
			
			
			@PutMapping("/{commentId}")
			public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request ) {
				return this.commentService.updateOneComment(commentId, request);
			}
			
			@DeleteMapping("/{commentId}")
			public void deleteOneComment(@PathVariable Long  commentId) {
				this.commentService.deleteOneCommentById(commentId);
			}
			
			
}
