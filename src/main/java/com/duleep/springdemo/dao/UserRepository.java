package com.duleep.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duleep.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
