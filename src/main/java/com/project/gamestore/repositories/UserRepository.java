package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gamestore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByPublicIdentifier(UUID publicIdentifier);
    public void deleteByPublicIdentifier(UUID publicIdentifier);
   
}