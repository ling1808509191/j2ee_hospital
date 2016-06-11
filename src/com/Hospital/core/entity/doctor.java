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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="doctor")
public class doctor implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = -7304823762500990104L;

private int id;
 private String name;
 private int level;
 private int price;
 private String account;
 private  String password;
 private transient apartment apartment;
 private transient hospital hospital;
 private String detel;
 private String imgurl;
 public String getDetel() {
	return detel;
}
public void setDetel(String detel) {
	this.detel = detel;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
private transient Set<plan> plan=new HashSet<plan>();
 private transient Set<record> records=new HashSet<record>();
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
@ManyToOne(targetEntity=apartment.class)
@JoinColumn(referencedColumnName="id",nullable=false)
public apartment getApartment() {
	return apartment;
}
public void setApartment(apartment apartment) {
	this.apartment = apartment;
}
@ManyToOne(targetEntity=hospital.class)
@JoinColumn(referencedColumnName="id",nullable=false)
public hospital getHospital() {
	return hospital;
}
public void setHospital(hospital hospital) {
	this.hospital = hospital;
}
@OneToMany(mappedBy="doctor",targetEntity=plan.class,fetch=FetchType.LAZY)
public Set<plan> getPlan() {
	return plan;
}
public void setPlan(Set<plan> plan) {
	this.plan = plan;
}
@OneToMany(mappedBy="doctor",targetEntity=record.class,fetch=FetchType.LAZY)
public Set<record> getRecords() {
	return records;
}
public void setRecords(Set<record> records) {
	this.records = records;
}
 
}
