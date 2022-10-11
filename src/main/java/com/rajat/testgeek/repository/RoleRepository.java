package com.rajat.testgeek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajat.testgeek.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
