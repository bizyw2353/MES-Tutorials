package com.mes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "accounts_code")
    private String accountCode;

    private String name;

    @Column(name = "business_number")
    private String businessNumber;

    private String ceo;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "business_category")
    private String businessCategory;

    private String tel;

    private String fax;

    private String email;

    private String address1;

    @Column(name = "address_detail1")
    private String addressDetail1;

    @Column(name = "zip_code")
    private String zipCode;

    private String address2;

    @Column(name = "address_detail2")
    private String addressDetail2;

    @Column(name = "zip_code2")
    private String zipCode2;

    private String etc;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountCode='" + accountCode + '\'' +
                ", name='" + name + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", ceo='" + ceo + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessCategory='" + businessCategory + '\'' +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", addressDetail1='" + addressDetail1 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address2='" + address2 + '\'' +
                ", addressDetail2='" + addressDetail2 + '\'' +
                ", zipCode2='" + zipCode2 + '\'' +
                ", etc='" + etc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddressDetail1() {
        return addressDetail1;
    }

    public void setAddressDetail1(String addressDetail1) {
        this.addressDetail1 = addressDetail1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddressDetail2() {
        return addressDetail2;
    }

    public void setAddressDetail2(String addressDetail2) {
        this.addressDetail2 = addressDetail2;
    }

    public String getZipCode2() {
        return zipCode2;
    }

    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
