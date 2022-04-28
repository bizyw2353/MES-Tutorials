package com.mes.dao;

import com.mes.entity.User;

import java.util.Date;
import java.util.List;

public class UserDao extends JpaDao<User> implements GenericDao<User>{



    @Override
    public User create(User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return super.create(user);
    }

    @Override
    public User find(Object id) {
        System.out.println("User.class = "+User.class);
        return super.find(User.class, id);
    }

    @Override
    public User update(User user) {
        user.setUpdatedAt(new Date());
        return super.update(user);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return super.findWithNamedQuery("User.findAll");
    }
}
