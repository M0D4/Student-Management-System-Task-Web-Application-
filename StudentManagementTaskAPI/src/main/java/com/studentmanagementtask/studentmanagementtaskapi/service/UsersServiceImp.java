package com.studentmanagementtask.studentmanagementtaskapi.service;

import com.studentmanagementtask.studentmanagementtaskapi.dao.UsersDAO;
import com.studentmanagementtask.studentmanagementtaskapi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService{
    UsersDAO usersDAO;

    @Autowired
    public UsersServiceImp(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    @Transactional
    public boolean userExists(String username, String password) {
        return usersDAO.userExists(username, password);
    }

    @Override
    public List<Users> getAll() {
        return usersDAO.getAll();
    }
}
