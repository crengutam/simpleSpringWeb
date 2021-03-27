package com.example.springWeb.datasource;

import com.example.springWeb.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDAO<User> implements UserDao{
    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
}
