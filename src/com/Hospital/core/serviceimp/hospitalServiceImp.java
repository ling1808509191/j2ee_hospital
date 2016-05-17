package com.Hospital.core.serviceimp;

import java.util.List;

import com.Hospital.core.daoimp.hospitalDaoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.entity.hospital;
import com.Hospital.core.service.hospitalService;
@Service
public class hospitalServiceImp implements hospitalService {
@Autowired
private hospitalDaoImp hospitalDaoImp;
@Transactional
	public boolean delHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.delHospital(hospital);
	}

@Transactional
	public List<hospital> getHospitals() {
		// TODO Auto-generated method stub
		return hospitalDaoImp.getAllHospitals();
	}

	@Transactional
	public List<hospital> getHospitals(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.getPartOfHospitals(pagenum, pagesize);
	}

	@Transactional
	public hospital getHospitalById(int id) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.getHospitalbyId(id);
	}

	@Transactional
	public hospital getHospitalByName(String name) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.getHospitalbyName(name);
	}

	@Transactional
	public hospital getHospitalByAccount(String account) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.getHospitalByAccount(account);
	}

	@Transactional
	public boolean saveHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.saveHospital(hospital);
	}

	@Transactional
	public boolean updateHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalDaoImp.updateHospital(hospital);
	}

}
