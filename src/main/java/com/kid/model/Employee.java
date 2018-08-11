package com.kid.model;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String fname;
    private String lname;
    private String address;
    private String mobile;
    private String tel;
    private String nic;
    private String email;
    private String designation;
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date joinedDate;
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date leftDate;
    private int active;
    private String remarks;
    private Date addedDate;
    private String addedBy;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Date getJoinedDate() {
        return joinedDate;
    }
    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }
    public Date getLeftDate() {
        return leftDate;
    }
    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
	return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", mobile=" + mobile + ", tel=" + tel + ", "
		+ "nic=" + nic + ", email=" + email + ", designation=" + designation + ", joinedDate=" + joinedDate + ", leftDate=" + leftDate + ", "
			+ "active=" + active + ", remarks=" + remarks + ", addedDate=" + addedDate + ", addedBy=" + addedBy + "]";
    }

   

    
}
