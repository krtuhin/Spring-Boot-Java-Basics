package com.springboot.dao;

import com.springboot.entities.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

//extends CrudRepository - provides functions for database operation
//we need to provide entity class name and type of primary key(id)
public interface UserRepository extends CrudRepository<User, Integer> {

    //custom finder method (user defined)
    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name, String city);

    public List<User> findByNameStartingWith(String prefix);

    public List<User> findByNameEndingWith(String suffix);

    public List<User> findByNameContaining(String word);

    public List<User> findByAgeLessThan(int age);

    public List<User> findByNameLike(String likePettern);

    public List<User> findByAgeIn(Collection<Integer> ages);
}
