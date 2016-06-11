package com.Hospital.core.model;

import java.util.List;

import com.Hospital.core.entity.apartment;

public interface hospitalModel {
	public boolean login(String account, String password);
	public boolean createApartment(int h_id, String account, String name, String password, String type);
	public boolean delApartmentById(int a_id);
	public boolean updateApartment(int a_id, String account, String name, String password, String type);
	public List<apartment> getApartments();
	public List<apartment> getApartments(int pagenum, int pagesize);
}
