package com.studentmanagementtask.studentmanagementtaskapi.service;

import com.studentmanagementtask.studentmanagementtaskapi.dao.StudentDAO;
import com.studentmanagementtask.studentmanagementtaskapi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImp(@Qualifier("studentDAOJpaimpl") StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    @Transactional
    public List<Student> getByIdOrName(String s) {
        return studentDAO.getByIdOrName(s);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void update(String nationalID, Student student) {
        studentDAO.update(nationalID, student);
    }

    @Override
    @Transactional
    public void delete(String nationalID) {
        studentDAO.delete(nationalID);
    }
}
