package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.patient;

public interface patienDao {
boolean savePatien(patient patient);
boolean delPatien(patient patient);
boolean updatePatien(patient patient);
doctor getDoctorByname(String name);
doctor getDoctorById(int id);
doctor getDoctorByAccount(String account);
List<doctor> getAllDoctors();

}
