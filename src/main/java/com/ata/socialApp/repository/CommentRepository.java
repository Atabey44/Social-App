package com.ata.socialApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.socialApp.entities.Comment;

public interface CommentRepository  extends JpaRepository<Comment, Long>{

			List<Comment> findByUserIdAndPostId(Long userId, Long postId);

			List<Comment> findByUserId(Long userId);

			List<Comment> findByPostId(Long postId);
	
}
