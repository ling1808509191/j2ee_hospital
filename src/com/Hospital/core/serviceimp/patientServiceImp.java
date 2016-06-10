package com.Hospital.core.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.patientDaoImp;
import com.Hospital.core.entity.patient;
import com.Hospital.core.service.patientService;
@Service
public class patientServiceImp implements patientService {
@Autowired
private patientDaoImp patientDaoImp;
@Transactional
	public boolean savePatient(patient patient) {
		// TODO Auto-generated method stub
		return patientDaoImp.savePatient(patient);
	}

@Transactional
	public boolean delPatient(patient patient) {
		// TODO Auto-generated method stub
		return patientDaoImp.delPatient(patient);
	}

@Transactional
	public boolean updatePatient(patient patient) {
		// TODO Auto-generated method stub
		return patientDaoImp.updatePatient(patient);
	}

@Transactional
	public List<patient> getPatientsByname(String name) {
		// TODO Auto-generated method stub
		return patientDaoImp.getPatientsByname(name);
	}
	@Transactional
	public patient getPatientById(int id) {
		// TODO Auto-generated method stub
		return patientDaoImp.getPatientById(id);
	}

	@Transactional
	public patient getPatientByAccount(String account) {
		// TODO Auto-generated method stub
		return patientDaoImp.getPatientByAccount(account);
	}

	@Transactional
	public List<patient> getPatients() {
		// TODO Auto-generated method stub
		return patientDaoImp.getAllPatients();
	}

	@Transactional
	public List<patient> getPatients(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return patientDaoImp.getPartOfPatients(pagenum, pagesize);
	}

}
