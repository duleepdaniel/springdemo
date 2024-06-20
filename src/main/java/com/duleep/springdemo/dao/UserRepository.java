package com.duleep.springdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.duleep.springdemo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
