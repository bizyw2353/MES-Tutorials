package com.mes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a ORDER BY a.createdAt")
})
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "accounts_code")
    private String accountCode;

    private String name;

    private String tel;

    private String fax;

    private String email;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

//    @Column(name = "business_number")
//    private String businessNumber;
//
//    private String ceo;
//
//    @Column(name = "business_type")
//    private String businessType;
//
//    @Column(name = "business_category")
//    private String businessCategory;
//
//
//    private String address1;
//
//    @Column(name = "address_detail1")
//    private String addressDetail1;
//
//    @Column(name = "zip_code")
//    private String zipCode;
//
//    private String address2;
//
//    @Column(name = "address_detail2")
//    private String addressDetail2;
//
//    @Column(name = "zip_code2")
//    private String zipCode2;
//
//    private String etc;


}
