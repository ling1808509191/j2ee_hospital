package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.patient;

public interface patientService {
	boolean savePatient(patient patient);
	boolean delPatient(patient patient);
	boolean updatePatient(patient patient);
	List<patient> getPatientsByname(String name);
	patient getPatientById(int id);
	patient getPatientByAccount(String account);
	List<patient> getPatients();
	List<patient> getPatients(int pagenum,int pagesize);
}
