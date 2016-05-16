package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.patient;

public interface patientDao {
boolean savePatient(patient patient);
boolean delPatient(patient patient);
boolean updatePatient(patient patient);
List<patient> getPatientsByname(String name);
patient getPatientById(int id);
patient getPatientByAccount(String account);
List<patient> getAllPatients();
List<patient> getPartOfPatients(int pagenum,int pagesize);
}
