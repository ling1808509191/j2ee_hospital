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
@Table(name="apartment")
public class apartment  implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -4604266709757832501L;
private int id;
private String name;
private String account;
private String password;
private hospital hospital;
private Set<doctor> doctors=new HashSet<doctor>();
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

@ManyToOne(targetEntity=hospital.class)
@JoinColumn(referencedColumnName="id",nullable=false)
public hospital getHospital() {
	return hospital;
}
public void setHospital(hospital hospital) {
	this.hospital = hospital;
}
@OneToMany(mappedBy="apartment",fetch=FetchType.LAZY,targetEntity=doctor.class)
public Set<doctor> getDoctors() {
	return doctors;
}
public void setDoctors(Set<doctor> doctors) {
	this.doctors = doctors;
}

}
