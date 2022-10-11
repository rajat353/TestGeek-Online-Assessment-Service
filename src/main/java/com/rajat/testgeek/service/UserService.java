package com.rajat.testgeek.service;

import java.util.Set;
import com.rajat.testgeek.models.User;
import com.rajat.testgeek.models.UserRole;

public interface UserService {

    public User addUser(User user, Set<UserRole> userRoles) throws Exception;
}
