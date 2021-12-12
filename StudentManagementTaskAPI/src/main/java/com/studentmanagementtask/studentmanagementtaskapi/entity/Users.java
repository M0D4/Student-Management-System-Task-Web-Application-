package com.studentmanagementtask.studentmanagementtaskapi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Pswd")
    private String password;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
