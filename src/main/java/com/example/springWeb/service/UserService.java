package com.example.springWeb.service;

import com.example.springWeb.datasource.UserDao;
import com.example.springWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public long createUser(User user){
        return userDao.create(user).getId();
    }

    public User updateUser(long id, User user){
        User existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userDao.update(existingUser);
    }

    public User findById(long id){
        return userDao.find(id);
    }

    public void deleteById(long id){
        userDao.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

}

