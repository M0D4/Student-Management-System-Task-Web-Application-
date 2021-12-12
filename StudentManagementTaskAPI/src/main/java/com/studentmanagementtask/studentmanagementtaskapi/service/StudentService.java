package com.studentmanagementtask.studentmanagementtaskapi.service;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();

    public List<Student> getByIdOrName(String s);

    public void save(Student student);

    public void update(String nationalID, Student student);

    public void delete(String nationalID);
}
