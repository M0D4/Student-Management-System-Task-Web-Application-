package com.studentmanagementtask.studentmanagementtaskapi.dao;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Users;

import java.util.List;

public interface UsersDAO {
    public boolean userExists(String username, String password);
    public List<Users> getAll();
}
