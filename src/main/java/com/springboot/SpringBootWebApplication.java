package com.springboot;

import com.springboot.dao.UserRepository;
import com.springboot.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);

        //get repository object from IoC container
        UserRepository userRepository = context.getBean(UserRepository.class);

        //create user object and set data
        User user = new User();

        user.setName("Tuhin Kumar");
        user.setCity("Kolkata");

        //save data into database
        User user1 = userRepository.save(user);

        System.out.println(user1);

        User user2 = new User("Raju", "Barasat");
        User user3 = new User("Soumya", "Khardah");

        //add multiple user in list 
        //this is introduced in java 9
        List<User> users = List.of(user3, user2);

        //save multiple user in database
        Iterable<User> resultUsers = userRepository.saveAll(users);

        //traverse in list and print data
        resultUsers.forEach(u -> {
            System.out.println(u);
        });

        //update data into database
        //get single object from database
        Optional<User> op = userRepository.findById(4);

        User rUser = op.get();

        //update value
        rUser.setCity("Bankura");

        //update data into database
        userRepository.save(rUser);

        System.out.println(rUser);

        //get multiple object from database
        Iterable<User> rUsers = userRepository.findAll();

        rUsers.forEach(u -> {
            System.out.println(u);
        });

        userRepository.deleteById(102);
        //same deleteAll(); to delete all users

        //get data from database using custom finder
        List<User> resultList = userRepository.findByName("Soumya");

        resultList.forEach(u -> {
            System.out.println(u);
        });

        //get data using custom finder method or derived method
        List<User> resultUserList = userRepository.findByNameAndCity("Raju", "Barasat");

        resultUserList.forEach(u -> {
            System.out.println(u);
        });

        //get data from database using JPQL
        List<User> userList = userRepository.selectAll();
        userList.forEach(u -> {
            System.out.println(u);
        });

        //get data from database using JPQL
        List<User> userLists = userRepository.selectUserByName("Soumya");
        userLists.forEach(u -> {
            System.out.println(u);
        });

        //get data from database using Native QueryFFFFFF
        List<User> usersList = userRepository.selectUserByCity("Kolkata");
        usersList.forEach(u -> {
            System.out.println(u);
        });
    }

}
