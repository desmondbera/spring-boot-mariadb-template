package com.mariadbtemplate.repository;

import org.springframework.data.repository.CrudRepository;
import com.mariadbtemplate.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByName(String name);
}
