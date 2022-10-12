package com.ata.socialApp.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ata.socialApp.entities.Like;

public interface LikeRepository extends JpaRepositoryImplementation<Like, Long> {

}
