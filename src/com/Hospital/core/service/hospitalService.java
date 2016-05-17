package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.hospital;

public interface hospitalService {
boolean delHospital(hospital hospital);
List<hospital> getHospitals();
List<hospital> getHospitals(int pagenum,int pagesize);
hospital getHospitalById(int id);
hospital getHospitalByName(String name);
hospital getHospitalByAccount(String account);
boolean saveHospital(hospital hospital);
boolean updateHospital(hospital hospital);
}
