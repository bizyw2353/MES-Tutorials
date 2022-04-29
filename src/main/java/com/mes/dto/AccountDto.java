package com.mes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountDto {
    private Integer id;
    private String accountCode;
    private String name;
//    private String businessNumber;
//    private String ceo;
//    private String businessType;
//    private String business_category;
    private String tel;
    private String fax;
    private String email;
//    private String address1;
//    private String addressDetail1;
//    private String zipCode1;
//    private String address2;
//    private String addressDetail2;
//    private String zipCode2;
//    private String etc;
    private Date createdAt;
    private Date updatedAT;
}
