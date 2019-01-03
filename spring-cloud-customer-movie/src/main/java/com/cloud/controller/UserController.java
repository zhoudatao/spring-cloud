package com.cloud.controller;

import com.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "customer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User user = restTemplate.getForObject("http://localhost:8000/provider/user/" + id,User.class);
        return user;
    }
}
