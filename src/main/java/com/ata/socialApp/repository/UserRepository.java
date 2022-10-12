package com.ata.socialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.socialApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
