package com.rajat.testgeek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rajat.testgeek.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

    public User findByUsername(String username);
    
}
