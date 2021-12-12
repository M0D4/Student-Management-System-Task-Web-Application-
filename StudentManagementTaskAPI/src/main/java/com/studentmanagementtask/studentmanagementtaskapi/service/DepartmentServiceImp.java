package com.studentmanagementtask.studentmanagementtaskapi.service;

import com.studentmanagementtask.studentmanagementtaskapi.dao.DepartmentDAO;
import com.studentmanagementtask.studentmanagementtaskapi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService{
    DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImp(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    @Transactional
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }
}
