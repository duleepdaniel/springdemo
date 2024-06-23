package com.duleep.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duleep.springdemo.dao.UserRepository;
import com.duleep.springdemo.model.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateUser(int id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            return userRepository.save(user);
        }).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public User save(User user) {
        System.out.print("Herererererere");
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        System.out.print(id);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    public User patchUpdateUser(int id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            if (updatedUser.getFirstName() != null) {
                user.setFirstName(updatedUser.getFirstName());
            }
            if (updatedUser.getLastName() != null) {
                user.setLastName(updatedUser.getLastName());
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
