package com.user.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.user.User.model.*;


public interface UserRepository extends JpaRepository<User, Integer> {

}
