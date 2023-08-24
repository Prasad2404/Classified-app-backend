package com.test.repository;


import com.test.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Role;

import java.util.Set;

public interface RoleRepository extends JpaRepository<UserRole,Long> {
    public Object save(Set<UserRole> roles);
}
