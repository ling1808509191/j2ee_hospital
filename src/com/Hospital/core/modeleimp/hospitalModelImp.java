package com.Hospital.core.modeleimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.hospital;
import com.Hospital.core.entity.manager;
import com.Hospital.core.model.hospitalModel;
import com.Hospital.core.serviceimp.apartmentServiceImp;
import com.Hospital.core.serviceimp.hospitalServiceImp;
@Component
public class hospitalModelImp implements hospitalModel {
	@Autowired
	private	hospitalServiceImp hsi;
	@Autowired
	private	apartmentServiceImp asi;
	
	public boolean login(String account, String password) {
		hospital h = hsi.getHospitalByAccount(account);
		if(password.equals(h.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean createApartment(int h_id, String account, String name, String password, String type) {
		hospital h = hsi.getHospitalById(h_id);
		apartment a = new apartment();
		a.setAccount(account);
		a.setName(name);
		a.setPassword(password);
		a.setHospital(h);
		a.setType(type);
		boolean r = asi.saveApartment(a);
		return r;
	}
	
	public boolean delApartmentById(int a_id) {
		apartment a = asi.getApartmentById(a_id);
		boolean r = asi.delApartment(a);
		return r;
	}
	
	public boolean updateApartment(int a_id, String account, String name, String password, String type) {
		apartment a = asi.getApartmentById(a_id);
		a.setAccount(account);
		a.setName(name);
		a.setPassword(password);
		a.setType(type);
		boolean r = asi.updateApartment(a);
		return r;
	}
	
	public List<apartment> getApartments() {
		return asi.getApartments();
	}
	
	public List<apartment> getApartments(int pagenum, int pagesize) {
		return asi.getApartments(pagenum, pagesize);
	}
}
