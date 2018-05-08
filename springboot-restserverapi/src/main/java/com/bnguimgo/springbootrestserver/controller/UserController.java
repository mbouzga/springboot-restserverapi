package com.bnguimgo.springbootrestserver.controller;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bnguimgo.springbootrestserver.dto.UserDTO;
import com.bnguimgo.springbootrestserver.entities.Role;
import com.bnguimgo.springbootrestserver.entities.User;
import com.bnguimgo.springbootrestserver.service.RoleService;
import com.bnguimgo.springbootrestserver.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@GetMapping(value = "/users")
	public ResponseEntity<Collection<User>> getAllUsers() {
		Collection<User> users = userService.getAllUsers();
		logger.info("liste des utilisateurs : " + users.toString());
		return new ResponseEntity<Collection<User>>(users, HttpStatus.FOUND);
	}

	@GetMapping("/user/{userId}")
	public UserDTO findUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@GetMapping(value = "/id/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
		UserDTO user = userService.getUserById(userId);

		logger.info("Utilisateur avec ID = [" + userId + "] : " + user.toString());

		return new ResponseEntity<UserDTO>(user, HttpStatus.FOUND);
	}

	@GetMapping(value = "/login/{login}")
	public UserDTO getUserByLogin(@PathVariable String login) {
		UserDTO user = userService.findByLogin(login);

		if(user == null){
			logger.info("Utilisateur avec LOGIN = [" + login + "] : n'existe pas");
		} else {
			logger.info("Utilisateur avec LOGIN = [" + login + "] : " + user.toString());
		}

		return user;
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDTO user) {

		UserDTO userToUpdate = userService.getUserById(id);
		if (userToUpdate == null) {
			logger.debug("L'utilisateur avec l'identifiant " + id + " n'existe pas");
			return new ResponseEntity<UserDTO>(userToUpdate, HttpStatus.NOT_FOUND);
		}

		logger.info("UPDATE ROLE: " + userToUpdate.getUserType());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setActive(user.getActive());
		UserDTO userUpdated = userService.saveOrUpdateUser(userToUpdate);
		return new ResponseEntity<UserDTO>(userUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {

		UserDTO userToUpdate = new UserDTO();

		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setActive(user.getActive());
		UserDTO userUpdated = userService.saveOrUpdateUser(userToUpdate);
		return new ResponseEntity<UserDTO>(userUpdated, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}

	@GetMapping(value = "/users/delete/{id}")
	public ResponseEntity<Void> deleteUseGet(@PathVariable(value = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}
	
	@GetMapping(value = "/roles")
	public ResponseEntity<Collection<Role>> getAllRoles() {
		Collection<Role> roles = roleService.getAllRoles();
		logger.info("liste des roles : " + roles.toString());
		return new ResponseEntity<Collection<Role>>(roles, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/logins")
	public ResponseEntity<Collection<String>> getAllLogins() {
		Collection<String> logins = userService.getAllLogins();
		logger.info("liste des logins : " + logins);
		return new ResponseEntity<Collection<String>>(logins, HttpStatus.FOUND);
	}
}
