package com.mes.dao;

import com.mes.dto.UserDto;
import com.mes.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean checkLogin(UserDto userDto) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userDto.getUserId());
        parameters.put("password", userDto.getPassword());

        List<User> listUser = super.findWithNamedQuery("User.checkLogin", parameters);

        if (listUser.size() < 1) {
            return false;
        }

        return true;

    }
}
