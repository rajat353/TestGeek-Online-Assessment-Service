package com.rajat.testgeek.controller;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.testgeek.models.UserRole.Role;
import com.rajat.testgeek.models.UserRole.User;
import com.rajat.testgeek.models.UserRole.UserRole;
import com.rajat.testgeek.service.UserService;
import com.rajat.testgeek.service.impl.UserDetailsImpl;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Create User Mapping
    @PostMapping("/")
    public User addUser(@RequestBody User user) throws Exception{

        //Making a default role type
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Role role= new Role();
        role.setRoleId(11L);
        role.setRoleName("Student");

        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);


        return this.userService.addUser(user, userRoles);
    }

    //Get User Mapping
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //Get all user details including roles
    @GetMapping("userdetail/{username}")
    public UserDetailsImpl getUserDetail(@PathVariable("username") String username){
        UserDetailsImpl userDetailsImpl= new UserDetailsImpl(this.userService.getUser(username));
        return userDetailsImpl;
    }

    //update user
    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") Long userId) throws Exception{
        return this.userService.updateUser(user, userId);
    }
         
    //Delete User Mapping
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

}
