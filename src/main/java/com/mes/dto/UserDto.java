package com.mes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String userId;
    private String password;
    private String name;
    private String department;
    private String position;
    private String tel;
    private String phone;
    private String email;
    private String address;
    private String athirity;
    private String etc;
    private Date createAt;
    private Date updateAt;
}

