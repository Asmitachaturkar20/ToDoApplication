package com.Auther.security_system.controller;

import com.Auther.security_system.model.User;
import com.Auther.security_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.attribute.standard.PresentationDirection;

@Controller
public class HomeController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepositoryser;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        System.out.println(user.toString());
        User newuser = new User();
        newuser.setUsername(user.getUsername());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepositoryser.save(newuser);
        return "redirect:/login";

    }

}


