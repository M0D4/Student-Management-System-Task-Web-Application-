package com.studentmanagementtask.studentmanagementtaskapi.rest;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Users;
import com.studentmanagementtask.studentmanagementtaskapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersRestController {
    UsersService usersService;

    @Autowired
    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    //mapping for userExists "/users"
    @GetMapping("/users")
    public boolean userExists(@RequestBody Users users){
        return usersService.userExists(users.getUsername(), users.getPassword());
    }

}
