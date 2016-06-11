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
@Table(name="hospital")
public class hospital implements Serializable{
	
	
	private static final long serialVersionUID = 2477193648354357367L;
	private int id;
	private String name;
	private String account;
	private String password;
	private String imgurl;
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	private transient Set<apartment> apartments=new HashSet<apartment>();
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
	@OneToMany(mappedBy="hospital",fetch=FetchType.LAZY,targetEntity=apartment.class)
	public Set<apartment> getApartments() {
		return apartments;
	}
	public void setApartments(Set<apartment> apartments) {
		this.apartments = apartments;
	}
	
	
	
	
}
