package com.Hospital.core.modeleimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.entity.patient;
import com.Hospital.core.model.patientModel;
import com.Hospital.core.serviceimp.patientServiceImp;
@Component
public class patientModelImp implements patientModel {
	@Autowired
	private patientServiceImp pasi;
	
	public boolean register(String account, String name, String password) {
		patient pa = new patient();
		pa.setAccount(account);
		pa.setName(name);
		pa.setPassword(password);
		boolean r = pasi.savePatient(pa);
		return r;
	}
	
	public boolean login(String account, String password) {
		patient pa = pasi.getPatientByAccount(account);
		if(password.equals(pa.getPassword())){
			return true;
		} else {
			return false;
		}
	}

}
