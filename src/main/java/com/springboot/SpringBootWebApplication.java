package com.springboot;

import com.springboot.dao.UserRepository;
import com.springboot.entities.User;
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
    }

}
