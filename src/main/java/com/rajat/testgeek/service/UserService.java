package com.rajat.testgeek.service;

import java.util.Set;

import com.rajat.testgeek.models.UserRole.User;
import com.rajat.testgeek.models.UserRole.UserRole;

public interface UserService {

    public User addUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);
    public void deleteUser(Long userId);
    public User updateUser(User user, Long userid) throws Exception;
}
