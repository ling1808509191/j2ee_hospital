package com.Hospital.core.entity;

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
@Table(name="apartment")
public class apartment {
	
private int id;
private String name;
private String account;
private String password;
private int h_id;
private hospital hospital;
private Set<doctor> doctors;
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
public int getH_id() {
	return h_id;
}
public void setH_id(int h_id) {
	this.h_id = h_id;
}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="h_id")
public hospital getHospital() {
	return hospital;
}
public void setHospital(hospital hospital) {
	this.hospital = hospital;
}
@OneToMany(mappedBy="apartment",fetch=FetchType.LAZY)
public Set<doctor> getDoctors() {
	return doctors;
}
public void setDoctors(Set<doctor> doctors) {
	this.doctors = doctors;
}

}
