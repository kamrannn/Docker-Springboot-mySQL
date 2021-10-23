package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
