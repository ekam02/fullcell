package com.rodriguez.fullcell.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rodriguez.fullcell.model.UserModel;
import com.rodriguez.fullcell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    private UserService userAction;

    @GetMapping("/user")
    public Iterable<UserModel> getUser() {
        return userAction.getAllUsers();
    }

    @PostMapping("/user/insert")
    public UserModel insertUser(@RequestBody UserModel user) {
        return userAction.createUser(user);
    }

    @PutMapping("/user/update")
    public UserModel updateUser(@RequestBody UserModel user) {
        return userAction.updateUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public String getUser(@PathVariable int id) {
        return userAction.deleteUser(id);
    }
    

}
