package com.bnguimgo.springbootrestserver.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bnguimgo.springbootrestserver.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

User findByLogin(String login);

@Query("SELECT u.login FROM User u")
Collection<String> getAllLogins();
}
