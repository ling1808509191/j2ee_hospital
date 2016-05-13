package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.doctor;

public interface doctorDao {
doctor getDoctorByname(String name);
doctor getDoctorByAccount(String account);
doctor getDoctorById(int id);
List<doctor> getAllDoctors();
boolean delDoctor(doctor doctor);
boolean updateDoctor(doctor doctor);
boolean saveDoctor(doctor doctor);
}
