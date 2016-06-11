package com.Hospital.core.model;

import java.util.List;

import com.Hospital.core.entity.doctor;

public interface apartmentModel {
	public boolean login(String account, String password);
	public boolean createDoctor(int a_id, int h_id, String account, String name, String password, int level, int price, String description, String imageUrl);
	public boolean delDoctorById(int d_id);
	public boolean updateDoctor(int a_id, int d_id, String account, String name, String password, int level, int price, String description, String imageUrl);
	public List<doctor> getDoctors();
	public List<doctor> getDoctors(int pagnum, int pagsize);
}	
