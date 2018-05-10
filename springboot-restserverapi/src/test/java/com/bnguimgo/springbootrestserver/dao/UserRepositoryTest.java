package com.bnguimgo.springbootrestserver.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnguimgo.springbootrestserver.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserRepository userRepository;
	User user = new User("Dupont", "password", 1);

	@Before
	public void setup() {
		entityManager.persist(user);// on sauvegarde l'objet user au début de
									// chaque test
		entityManager.flush();
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = userRepository.findAll();
		
		// on a trois users dans le fichier d'initialisation data.sql et un utilisateur ajouté
		assertTrue(users.size()>0);
		
		//assertThat(4, is(users.size()));
										
	}

	@Test
	public void testSaveUser() {
		User user = new User("Paul", "password", 1);
		User userSaved = userRepository.save(user);
		assertNotNull(userSaved.getId());
		assertThat("Paul", is(userSaved.getLogin()));
	}

	@Test
	public void testFindByLogin() {
		User userFromDB = userRepository.findByLogin("Dupont");
		
		// usera été créé lors de l'initialisation du fichier data.sql 
		assertThat("Dupont", is(userFromDB.getLogin()));
	}

	@Test
	public void testDeleteUser() {
		//userRepository.delete(user.getId());
		User userFromDB = userRepository.findByLogin(user.getLogin());
		// Avant Suppression
		assertNotNull(userFromDB);
		// Apres suppression
		//assertNull(userFromDB);
	}

	@Test
	public void testUpdateUser() {// Test si le compte utilisateur est désactivé
		User userToUpdate = userRepository.findByLogin(user.getLogin());
		userToUpdate.setActive(0);
		userRepository.save(userToUpdate);
		User userUpdatedFromDB = userRepository.findByLogin(userToUpdate.getLogin());
		assertNotNull(userUpdatedFromDB);
		assertThat(0, is(userUpdatedFromDB.getActive()));
	}
}