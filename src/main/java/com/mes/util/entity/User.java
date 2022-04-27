package com.mes.util.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
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

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
