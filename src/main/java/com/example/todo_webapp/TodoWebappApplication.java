package com.example.todo_webapp;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/get/all/")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<UserModel> getUser(@PathVariable Long id) {
        return userRepository.findById(Math.toIntExact(id));
    }

    @PostMapping("/post/")
    public UserModel createUser(@Valid @RequestBody UserModel user) {
//        System.out.println(user);
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}/")
    public Map<String, String> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(Math.toIntExact(id));
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("status", "User with id: "+ id + " has been deleted");
        return returnValue;
    }
}
