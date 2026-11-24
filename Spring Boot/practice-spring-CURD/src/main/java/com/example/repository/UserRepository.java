package com.example.repository;


import com.example.dummyDB.DatabaseConnected;

import java.util.List;

public class UserRepository {
    private DatabaseConnected db;

    public UserRepository(DatabaseConnected db) {
        this.db = db;
    }
    public List<String> findAll() {
        return db.getUsers();
    }

    public void save(String user) {
        db.addUser(user);
    }
}
