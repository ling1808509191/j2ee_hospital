package com.Hospital.core.modeleimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.hospital;
import com.Hospital.core.model.apartmentModel;
import com.Hospital.core.serviceimp.apartmentServiceImp;
import com.Hospital.core.serviceimp.doctorServiceImp;
import com.Hospital.core.serviceimp.hospitalServiceImp;
@Component
public class apartmentModelImp implements apartmentModel {
	@Autowired
	private apartmentServiceImp asi;
	@Autowired
	private	doctorServiceImp dsi;
	@Autowired
	private	hospitalServiceImp hsi;
	
	public boolean login(String account, String password) {
		apartment a = asi.getApartmentByAccount(account);
		if(password.equals(a.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean createDoctor(int a_id, int h_id, String account, String name, String password, int level, int price) {
		apartment a = asi.getApartmentById(a_id);
		hospital h = hsi.getHospitalById(h_id);
		doctor d = new doctor();
		d.setAccount(account);
		d.setApartment(a);
		d.setHospital(h);
		d.setLevel(level);
		d.setName(name);
		d.setPassword(password);
		d.setPrice(price);
		boolean r = dsi.saveDoctor(d);
		return r;
	}
	
	public boolean delDoctorById(int d_id) {
		doctor d = dsi.getDoctorById(d_id);
		boolean r = dsi.delDoctor(d);
		return r;
	}
	
	public boolean updateDoctor(int a_id, int d_id, String account, String name, String password, int level, int price) {
		doctor d = dsi.getDoctorById(d_id);
		d.setAccount(account);
		d.setName(name);
		d.setPassword(password);
		d.setPrice(price);
		d.setLevel(level);
		boolean r = dsi.updateDoctor(d);
		return r;
	}
	
	public List<doctor> getDoctors() {
		return dsi.getDoctors();
	}
	
	public List<doctor> getDoctors(int pagenum, int pagesize) {
		return dsi.getDoctors(pagenum, pagesize);
	}
}
