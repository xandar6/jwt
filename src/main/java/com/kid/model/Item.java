package com.kid.model;

import java.io.Serializable;
import java.sql.Date;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String itemCode;
    private String itemName;
    private String itemDesc;
    private String itemType;
    private int amount;
    private double cost;
    private double price;
    private String status;
    private String color;
    private int active;
    private Date addedDate;
    private String addedBy;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
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
	return "Item [id=" + id + ", itemCode=" + itemCode + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemType=" + itemType + ", amount=" + amount + ", cost=" + cost + ", price=" + price + ", status=" + status + ", color=" + color + ", active=" + active + ", addedDate=" + addedDate + ", addedBy=" + addedBy + "]";
    }
    
   
    
    
}
