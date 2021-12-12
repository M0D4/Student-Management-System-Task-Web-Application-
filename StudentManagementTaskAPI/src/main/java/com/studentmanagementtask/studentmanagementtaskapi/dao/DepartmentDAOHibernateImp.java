package com.studentmanagementtask.studentmanagementtaskapi.dao;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DepartmentDAOHibernateImp implements DepartmentDAO{
    EntityManager entityManager;

    @Autowired
    public DepartmentDAOHibernateImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Department> query =
                session.createQuery("FROM Department ORDER BY Name", Department.class);

        return query.getResultList();
    }
}
