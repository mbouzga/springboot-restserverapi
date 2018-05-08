package com.bnguimgo.springbootrestserver.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnguimgo.springbootrestserver.dao.UserRepository;
import com.bnguimgo.springbootrestserver.dto.UserDTO;
import com.bnguimgo.springbootrestserver.entities.User;
import com.bnguimgo.springbootrestserver.utils.UserUtils;

@Service(value = "userService") // l'annotation @Service est optionnelle ici,
								// car il n'existe qu'une seule implémentation
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDTO findByLogin(String login) {
		User user = userRepository.findByLogin(login);
		return UserUtils.mapUserEntityToDto(user);
	}

	@Override
	public Collection<User> getAllUsers() {
		return IteratorUtils.toList(userRepository.findAll().iterator());
	}

	@Override
	public UserDTO getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return UserUtils.mapUserEntityToDto(user.get());
	}

	@Override
	@Transactional(readOnly = false)
	public UserDTO saveOrUpdateUser(UserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User userEntity = userRepository.save(UserUtils.mapUserDtoToEntity(user));
		return UserUtils.mapUserEntityToDto(userEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Collection<String> getAllLogins() {
		return userRepository.getAllLogins();
	}

}
