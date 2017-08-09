package com.java.springhibernate.bean;

public class PurchaseItem {
private Integer pid;
private Integer itemid;
private String catogory;
private String description;
private Integer price;
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public Integer getItemid() {
	return itemid;
}
public void setItemid(Integer itemid) {
	this.itemid = itemid;
}
public String getCatogory() {
	return catogory;
}
public void setCatogory(String catogory) {
	this.catogory = catogory;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}

}
