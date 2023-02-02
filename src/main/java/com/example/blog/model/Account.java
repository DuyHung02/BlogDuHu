package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String gmail;
    private String password;
    private String userName;
    private String avatar;

    public Account() {
    }

    public Account(long id, String gmail, String password, String userName) {
        this.id = id;
        this.gmail = gmail;
        this.password = password;
        this.userName = userName;
    }

    public Account(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }

    public Account(long id, String gmail, String password, String userName, String avatar) {
        this.id = id;
        this.gmail = gmail;
        this.password = password;
        this.userName = userName;
        this.avatar = avatar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
