package com.mariadbtemplate.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mariadbtemplate.domain.User;
import com.mariadbtemplate.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		User user1 = new User("Alice", 23);
		User user2 = new User("Desmond", 32);
		// save user, verify has ID value after save
		assertNull(user1.getId());
		assertNull(user2.getId());// null before save
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		assertNotNull(user1.getId());
		assertNotNull(user2.getId());
	}

	@Test
	public void testFetchData() {
		/* Test data retrieval */
		User userA = userRepository.findByName("Desmond");
		System.out.println("our UserA is: " + userA);
		assertNotNull(userA);
		assertEquals(32, userA.getAge());
		/* Get all products, list should only have two */
		Iterable<User> users = userRepository.findAll();
		int count = 0;
		for (User p : users) {
			count++;
		}
		assertEquals(count, 2);
	}

}
