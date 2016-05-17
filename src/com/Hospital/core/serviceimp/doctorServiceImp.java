package com.Hospital.core.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.doctorDaoImp;
import com.Hospital.core.entity.doctor;
import com.Hospital.core.service.doctorService;
@Service
public class doctorServiceImp implements doctorService {
@Autowired
private doctorDaoImp doctorDaoImp;
@Transactional
	public List<doctor> getDoctorByname(String name) {
		// TODO Auto-generated method stub
		return doctorDaoImp.getDoctorByname(name);
	}

	@Transactional
	public doctor getDoctorByAccount(String account) {
		// TODO Auto-generated method stub
		return doctorDaoImp.getDoctorByAccount(account);
	}

	@Transactional
	public doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorDaoImp.getDoctorById(id);
	}

	@Transactional
	public List<doctor> getDoctors() {
		// TODO Auto-generated method stub
		return doctorDaoImp.getAllDoctors();
	}

	@Transactional
	public List<doctor> getDoctors(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return doctorDaoImp.getPartOfDoctors(pagenum, pagesize);
	}

	@Transactional
	public boolean delDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDaoImp.delDoctor(doctor);
	}

	@Transactional
	public boolean updateDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDaoImp.updateDoctor(doctor);
	}

	@Transactional
	public boolean saveDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDaoImp.saveDoctor(doctor);
	}

}
