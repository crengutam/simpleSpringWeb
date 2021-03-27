package com.example.springWeb.datasource;


import com.example.springWeb.model.User;

import java.util.List;

public interface UserDao {
    User find(long id);
    List<User> findAll();
    User create(User user);
    User update(User user);

    void delete(User user);
    void deleteById(long id);

}
