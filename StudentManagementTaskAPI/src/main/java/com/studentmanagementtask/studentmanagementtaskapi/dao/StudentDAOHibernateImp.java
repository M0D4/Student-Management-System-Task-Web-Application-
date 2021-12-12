package com.studentmanagementtask.studentmanagementtaskapi.dao;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;


@Repository
public class StudentDAOHibernateImp implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> getAll(){
        Session session = entityManager.unwrap(Session.class);

        Query<Student> query =
                session.createQuery("FROM Student ORDER BY Name", Student.class);

        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public List<Student> getByIdOrName(String s) {
        Session session = entityManager.unwrap(Session.class);

        Query<Student> query =
                session.createQuery(String.format("FROM Student WHERE NationalID LIKE ('%1$c%2$s%1$c') OR Name LIKE" +
                        " ('%1$c%2$s%1$c') ORDER BY Name", '%', s), Student.class);

        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
    }

    @Override
    @Modifying
    public void update(String nationalID, Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
       /* Query query =
                session.createQuery("update Student SET" +
                        " Name = :name," +
                        " Department = :department," +
                        " NationalID = :newNationalID," +
                        " mobile_number = :mobile_Number" +
                        " WHERE NationalID = :nationalID");

        query.setParameter("name", student.getName());
        query.setParameter("department", student.getDepartment());
        query.setParameter("newNationalID", student.getNationalID());
        query.setParameter("mobile_Number", student.getMobileNumber());
        query.setParameter("nationalID", nationalID);
        query.executeUpdate();*/
    }

    @Override
    public void delete(String nationalID) {
        Session session = entityManager.unwrap(Session.class);
        Query query =
                session.createQuery("DELETE FROM Student WHERE NationalID = :studentID");

        query.setParameter("studentID", nationalID);
        query.executeUpdate();
    }
}
