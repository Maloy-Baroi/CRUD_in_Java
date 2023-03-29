

package com.example.todo_webapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<UserModel, Integer> {
}


