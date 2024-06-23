package com.duleep.springdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.duleep.springdemo.dao.UserRepository;
import com.duleep.springdemo.model.User;
import com.duleep.springdemo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView home(@RequestParam(value = "name", required = false, defaultValue = "World") String myName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", myName);
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("getusers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/fetchuser/{id}")
    @ResponseBody
    public Optional<User> fetchUser(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping(path = "/adduser", consumes = { "application/json" })
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/updateuser/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/removeuser/{id}")
    @ResponseBody
    public String removeUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "deleted";
    }

    @PatchMapping("/updateuser/{id}")
    @ResponseBody
    public User patchUpdateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
        return userService.patchUpdateUser(id, updatedUser);
    }
}
