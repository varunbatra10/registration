package com.digilytics.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digilytics.registration.model.User;

@Repository(value="userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

}
