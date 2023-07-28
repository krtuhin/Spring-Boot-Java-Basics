package com.springboot.dao;

import com.springboot.entities.User;
import org.springframework.data.repository.CrudRepository;

//extends CrudRepository - provides functions for database operation
//we need to provide entity class name and type of primary key(id)
public interface UserRepository extends CrudRepository<User, Integer> {

}
