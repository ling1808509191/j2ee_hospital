package com.Hospital.core.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="patient")
public class patient implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -7761444441978741313L;
private int id;
private String name;
private String account;
private String password;
private int money;
private transient Set<record> records=new HashSet<record>();
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
@OneToMany(mappedBy="patient",targetEntity=record.class,fetch=FetchType.LAZY)
public Set<record> getRecords() {
	return records;
}
public void setRecords(Set<record> records) {
	this.records = records;
}
}
