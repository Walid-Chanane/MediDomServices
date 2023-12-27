package com.medidomservices.medidom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medidomservices.medidom.Entity.User.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
