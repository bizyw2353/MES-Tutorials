package com.mes.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.checkLogin", query = "SELECT u FROM User u WHERE u.userId = :userId AND u.password = :password")
})
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id", unique = true)
    private String userId;

    private String password;

    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

//    private String department;
//
//    private String position;
//
//    private String tel;
//
//    private String phone;
//
//    private String email;
//
//    private String address;
//
//    private String athirity;
//
//    private String etc;

}
