package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.hospital;

public interface hospitalDao {
hospital getHospitalbyName(String name);
hospital getHospitalbyId(int id);
hospital getHospitalByAccount(String account);
List<hospital> getAllHospitals();
List<hospital> getPartOfHospitals(int pagenum,int pagesize);
boolean saveHospital(hospital hospital);
boolean delHospital(hospital hospital);
boolean updateHospital(hospital hospital);
//Set<apartment> getApartments(hospital hospital);
//Object excuHql(String hql);
}
