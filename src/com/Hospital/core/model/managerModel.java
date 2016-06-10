package com.Hospital.core.model;

import java.util.List;

import com.Hospital.core.entity.hospital;

public interface managerModel {
	public boolean login(String account, String password);
	public boolean createHospital(String account, String name, String password);
	public boolean delHospitalById(int h_id);
	public boolean updateHospital(int h_id, String account, String name, String password);
	public List<hospital> getHospitals();
	public List<hospital> getHospitals(int pagnum, int pagsize);
}
