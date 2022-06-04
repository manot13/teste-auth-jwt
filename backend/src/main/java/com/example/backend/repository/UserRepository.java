package com.example.backend.repository;


import com.example.backend.entity.UserR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserR, String> {

}
