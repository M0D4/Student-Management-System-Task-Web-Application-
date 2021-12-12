package com.studentmanagementtask.studentmanagementtaskapi.rest;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Department;
import com.studentmanagementtask.studentmanagementtaskapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentRestController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //mapping for "/departments"
    @GetMapping("/departments")
    public List<Department> getAll(){
        return departmentService.getAll();
    }
}
