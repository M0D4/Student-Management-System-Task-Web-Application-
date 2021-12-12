package com.studentmanagementtask.studentmanagementtaskapi.service;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Users;

import java.util.List;

public interface UsersService {
    public boolean userExists(String username, String password);
    public List<Users> getAll();
}
