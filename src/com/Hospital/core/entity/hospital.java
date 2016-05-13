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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

@Entity
@Table(name="hospital")
public class hospital {
	
	private int id;
	private String name;
	private String account;
	private String password;
	private Set<apartment> apartments;
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
	@OneToMany(mappedBy="hospital",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Set<apartment> getApartments() {
		return apartments;
	}
	public void setApartments(Set<apartment> apartments) {
		this.apartments = apartments;
	}
	
	
	
	
}
