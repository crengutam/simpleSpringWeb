package com.example.springWeb.controller;

import com.example.springWeb.model.User;
import com.example.springWeb.service.UserService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) long id, @RequestBody User user) {
        Preconditions.checkNotNull(user);
        service.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        service.deleteById(id);
    }
}
