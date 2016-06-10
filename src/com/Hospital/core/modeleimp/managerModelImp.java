package com.Hospital.core.modeleimp;

import java.util.List;

import com.Hospital.core.entity.hospital;
import com.Hospital.core.entity.manager;
import com.Hospital.core.model.managerModel;
import com.Hospital.core.serviceimp.hospitalServiceImp;
import com.Hospital.core.serviceimp.managerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class managerModelImp implements managerModel{
	@Autowired
	private managerServiceImp msi;
	@Autowired
	private hospitalServiceImp hsi;
	
	public boolean login(String account, String password) {
		manager m = msi.getManagerByaccount(account);
		if(password.equals(m.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean createHospital(String account, String name, String password) {
		hospital h = new hospital();
		h.setAccount(account);
		h.setName(name);
		h.setPassword(password);
		boolean r = hsi.saveHospital(h);
		return r;
	}
	
	public boolean delHospitalById(int h_id) {
		hospital h = hsi.getHospitalById(h_id);
		boolean r = hsi.delHospital(h);
		return r;
	}
	
	public boolean updateHospital(int h_id, String account, String name, String password) {
		hospital h = hsi.getHospitalById(h_id);
		h.setAccount(account);
		h.setName(name);
		h.setPassword(password);
		boolean r = hsi.updateHospital(h);
		return r;
	}

	public List<hospital> getHospitals() {
		return hsi.getHospitals();
	}
	
	public List<hospital> getHospitals(int pagenum, int pagesize) {
		return hsi.getHospitals(pagenum, pagesize);
	}

}
