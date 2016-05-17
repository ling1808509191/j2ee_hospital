package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.doctor;

public interface doctorService {
	List<doctor> getDoctorByname(String name);
	doctor getDoctorByAccount(String account);
	doctor getDoctorById(int id);
	List<doctor> getDoctors();
	List<doctor> getDoctors(int pagenum,int pagesize);
	boolean delDoctor(doctor doctor);
	boolean updateDoctor(doctor doctor);
	boolean saveDoctor(doctor doctor);
}
