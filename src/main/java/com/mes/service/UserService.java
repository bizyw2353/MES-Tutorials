package com.mes.service;

import com.mes.dao.UserDao;
import com.mes.dto.UserDto;
import com.mes.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    //회원가입
    public User createUser(UserDto userDto){

        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());

        User createdUser = userDao.create(user);

        if (createdUser == null) {
            System.out.println("회원가입 실패");
            return null;
        }
        return createdUser;
    }

    //회원수정
    public User updateUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUserId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());

        User updateUser = userDao.update(user);

        if (updateUser == null) {
            System.out.println("정보수정 실패");
            return null;
        }
        return updateUser;
    }

    //회원리스트
    public List<User> findAllUser() {
        /*List<User> userList = userDao.findAll();
        return userList;*/

        return userDao.findWithNamedQuery("User.findAll");
    }

    //회원찾기
    public User findUserById(Integer id){
        return userDao.find(id);

    }
}
