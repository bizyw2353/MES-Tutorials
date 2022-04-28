package com.mes.controller.user;

import com.mes.dto.UserDto;
import com.mes.entity.User;
import com.mes.service.UserService;
import com.mes.util.HashGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserCreateProcControllerTest {

    @Test
    public void createUser() {
        UserService userService = new UserService();

        String userId = "testJoin";
        String password = "qlqjs";
        String md5 = HashGenerator.generateMD5(password);
        String name = "예원";

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setPassword(md5);
        userDto.setName(name);

        User createdUser = userService.createUser(userDto);

        assertTrue(createdUser instanceof User);
        assertEquals(userId, createdUser.getUserId());
        assertEquals(name, createdUser.getName());
    }
}