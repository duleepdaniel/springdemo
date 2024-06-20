package com.duleep.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.duleep.springdemo.dao.UserRepository;
import com.duleep.springdemo.model.User;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView home(@RequestParam(value = "name", required = false, defaultValue = "World") String myName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", myName);
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("getUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
