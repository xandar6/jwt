package com.kid.model;

import java.io.Serializable;
import java.sql.Date;

public class Driver implements Serializable {


    private static final long serialVersionUID = 1L;
    private int id;
    private int employeeId;
    private Date driverFrom;
    private Date driverTo;
    private String status;
    private int active;
    private Date addedDate;
    private String addedBy;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public Date getDriverFrom() {
        return driverFrom;
    }
    public void setDriverFrom(Date driverFrom) {
        this.driverFrom = driverFrom;
    }
    public Date getDriverTo() {
        return driverTo;
    }
    public void setDriverTo(Date driverTo) {
        this.driverTo = driverTo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
	return "Driver [id=" + id + ", employeeId=" + employeeId + ", driverFrom=" + driverFrom + ", driverTo=" + driverTo + ", status=" + status + ", "
		+ "active=" + active + ", addedDate=" + addedDate + ", addedBy=" + addedBy + "]";
    }
    
    
    
}
