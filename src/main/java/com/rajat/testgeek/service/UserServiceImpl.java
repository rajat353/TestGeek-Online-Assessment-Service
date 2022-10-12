package com.rajat.testgeek.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rajat.testgeek.models.User;
import com.rajat.testgeek.models.UserRole;
import com.rajat.testgeek.repository.RoleRepository;
import com.rajat.testgeek.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Add a New User
    @Override
    public User addUser(User user, Set<UserRole> userRoles) throws Exception {
        User insertUser = this.userRepository.findByUsername(user.getUsername());

        // check if user already exist in the database
        if (insertUser != null) {
            System.out.println("Sorry!! User with UserName " + insertUser.getUsername() + "already exist.");
            throw new Exception("User Already Exist!!");
        } else {

            // save roles in roleRepository from all userRoles
            for (UserRole userRole : userRoles)
                this.roleRepository.save(userRole.getRole());

            user.getUserRoles().addAll(userRoles);
            insertUser = this.userRepository.save(user);
        }

        return insertUser;

    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
       this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user, Long userId) throws Exception {
        User updateUser= this.userRepository.findById(userId).orElse(null);
        if(updateUser==null){
            System.out.println("Sorry!! User with UserName " + user.getUsername() + "doesn't exist.");
            throw new Exception("User doesn't Exist!!");
        }
        user.setUserId(userId);
        return this.userRepository.save(user);
        
    }

}
