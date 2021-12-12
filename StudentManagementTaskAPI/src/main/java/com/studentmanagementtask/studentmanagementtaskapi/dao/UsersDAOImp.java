package com.studentmanagementtask.studentmanagementtaskapi.dao;

import com.studentmanagementtask.studentmanagementtaskapi.entity.Users;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UsersDAOImp implements UsersDAO{
    EntityManager entityManager;

    @Autowired
    public UsersDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean userExists(String username, String password) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("From Users where Username = :username and Pswd = md5(:pswd)", Users.class);
        query.setParameter("username", username);
        query.setParameter("pswd", password);

        return (query.getResultList().size() == 1);
    }

    @Override
    public List<Users> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("FROM Users", Users.class);

        return query.getResultList();
    }
}
