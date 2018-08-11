package com.kid.model;

import java.io.Serializable;
import java.sql.Date;

public class ComboItem implements Serializable {


    private static final long serialVersionUID = 1L;
    private int id;
    private String comboName;
    private String comboDesc;
    private int defaultQty;
    private String varient;
    private String theme;
    private int active;
    private Date addedDate;
    private String addedBy;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getComboName() {
        return comboName;
    }
    public void setComboName(String comboName) {
        this.comboName = comboName;
    }
    public String getComboDesc() {
        return comboDesc;
    }
    public void setComboDesc(String comboDesc) {
        this.comboDesc = comboDesc;
    }
    public int getDefaultQty() {
        return defaultQty;
    }
    public void setDefaultQty(int defaultQty) {
        this.defaultQty = defaultQty;
    }
    public String getVarient() {
        return varient;
    }
    public void setVarient(String varient) {
        this.varient = varient;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
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
	return "ComboItem [id=" + id + ", comboName=" + comboName + ", comboDesc=" + comboDesc + ", defaultQty=" + defaultQty + ", varient=" + varient + ", theme=" + theme + ", active=" + active + ", addedDate=" + addedDate + ", addedBy=" + addedBy + "]";
    }
    

    
    
    
}
