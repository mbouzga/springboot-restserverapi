package com.bnguimgo.springbootrestserver.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.bnguimgo.springbootrestserver.dto.UserDTO;
import com.bnguimgo.springbootrestserver.entities.User;

public interface UserService {

	Collection<User> getAllUsers();

	UserDTO getUserById(Long id);

	UserDTO findByLogin(String login);

	UserDTO saveOrUpdateUser(UserDTO userToUpdate);

	void deleteUser(Long id);

	Collection<String> getAllLogins();

}