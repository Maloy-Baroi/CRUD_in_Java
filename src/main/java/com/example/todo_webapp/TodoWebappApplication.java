package com.example.todo_webapp;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/users")
public class TodoWebappApplication {

    private final UserRepository userRepository;

    @Autowired
    public TodoWebappApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoWebappApplication.class, args);
    }

//    record NewUserData (
//            String Name,
//    ) {}

    @GetMapping("/get-all/")
    public List<UserModel> getUsers() {
        return userRepository.findAll();
//        return List.of();
    }

    @PostMapping("/post/")
    public UserModel createUser(@Valid @RequestBody UserModel user) {
//        System.out.println(user);
        return userRepository.save(user);
    }
}
