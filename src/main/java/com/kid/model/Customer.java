package com.kid.model;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable {
    

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String address;
    private String mobile1;
    private String mobile2;
    private String telHome;
    private String telOffice;
    private String email;
    private String remarks;
    private int active;
    private Date addedDate;
    private String addedBy;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile1() {
        return mobile1;
    }
    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }
    public String getMobile2() {
        return mobile2;
    }
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }
    public String getTelHome() {
        return telHome;
    }
    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }
    public String getTelOffice() {
        return telOffice;
    }
    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public Date getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
    public String getAddedBy() {
        return addedBy;
    }
    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
    
    @Override
    public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", telHome=" + telHome + ", telOffice=" + telOffice + ", email=" + email + ", remarks=" + remarks + ", active=" + active + ", addedDate=" + addedDate + ", addedBy=" + addedBy + "]";
    }
    
    
    
}
