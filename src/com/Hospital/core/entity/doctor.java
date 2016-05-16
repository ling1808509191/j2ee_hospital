package com.Hospital.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="doctor")
public class doctor {
 private int id;
 private String name;
 private int level;
 private int price;
 private int h_id;
 private int a_id;
 private String account;
 private  String password;
 private apartment apartment;
 private hospital hospital;
 private Set<plan> plan;
 private Set<record> records;
 public doctor() {
	// TODO Auto-generated constructor stub
	 plan=new HashSet<plan>();
}
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
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getH_id() {
	return h_id;
}
public void setH_id(int h_id) {
	this.h_id = h_id;
}
public int getA_id() {
	return a_id;
}
public void setA_id(int a_id) {
	this.a_id = a_id;
}
@Column(unique=true)
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
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="a_id")
public apartment getApartment() {
	return apartment;
}
public void setApartment(apartment apartment) {
	this.apartment = apartment;
}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="h_id")
public hospital getHospital() {
	return hospital;
}
public void setHospital(hospital hospital) {
	this.hospital = hospital;
}
@OneToMany(mappedBy="doctor",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
public Set<plan> getPlan() {
	return plan;
}
public void setPlan(Set<plan> plan) {
	this.plan = plan;
}
@OneToMany(mappedBy="records",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
public Set<record> getRecords() {
	return records;
}
public void setRecords(Set<record> records) {
	this.records = records;
}
 
}
