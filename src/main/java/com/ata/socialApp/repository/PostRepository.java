package com.ata.socialApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ata.socialApp.entities.Post;

public interface PostRepository  extends JpaRepository<Post, Long>{

				List<Post>  findByUserId(Long userId);

}
