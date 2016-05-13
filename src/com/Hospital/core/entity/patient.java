package com.Hospital.core.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class patient {
private int id;
private String name;
private String account;
private String password;
private int money;
private Set<record> records;
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
@Column(name = "id", unique = true, nullable =true,updatable=false)
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
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
@OneToMany(mappedBy="patient",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
public Set<record> getRecords() {
	return records;
}
public void setRecords(Set<record> records) {
	this.records = records;
}
}
