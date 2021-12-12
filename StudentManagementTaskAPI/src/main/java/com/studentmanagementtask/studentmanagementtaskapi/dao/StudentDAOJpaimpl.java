package com.studentmanagementtask.studentmanagementtaskapi.dao;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAOJpaimpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOJpaimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll() {
        Query query =
                entityManager.createQuery(String.format("FROM Student ORDER BY Name"));

        return (List<Student>) query.getResultList();
    }

    @Override
    public List<Student> getByIdOrName(String s) {
        Query query =
                entityManager.createQuery(String.format("FROM Student WHERE NationalID LIKE ('%1$c%2$s%1$c') OR Name LIKE" +
                        " ('%1$c%2$s%1$c') ORDER BY Name", '%', s));

        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        Student dbStudent = entityManager.merge(student);
    }

    @Override
    public void update(String nationalID, Student student) {
        Query query =
                entityManager.createQuery(String.format("UPDATE Student s SET" +
                        " s.name = :name," +
                        " s.department = :department," +
                        " s.nationalID = :newNationalID," +
                        " s.mobileNumber = :mobile_Number" +
                        " WHERE s.nationalID = :nationalID"));

        query.setParameter("name", student.getName());
        query.setParameter("department", student.getDepartment());
        query.setParameter("newNationalID", student.getNationalID());
        query.setParameter("mobile_Number", student.getMobileNumber());
        query.setParameter("nationalID", nationalID);
        query.executeUpdate();
    }

    @Override
    public void delete(String nationalID) {
        Query query =
                entityManager.createQuery(String.format("DELETE FROM Student WHERE NationalID = :studentID"));

        query.setParameter("studentID", nationalID);
        query.executeUpdate();
    }
}
