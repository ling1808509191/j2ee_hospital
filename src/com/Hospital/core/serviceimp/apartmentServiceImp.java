package com.Hospital.core.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.apartmentDaoImp;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.service.apartmentService;
@Service
public class apartmentServiceImp implements apartmentService {
@Autowired
private apartmentDaoImp apartmentDaoImp;

	@Transactional
	
	public boolean saveApartment(apartment apartment) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.saveApartment(apartment);
	}

	@Transactional
	public boolean delApartment(apartment apartment) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.delApartment(apartment);
	}

	@Transactional
	public List<apartment> getApartments() {
		// TODO Auto-generated method stub
		return apartmentDaoImp.getAllApartments();
	}

	@Transactional
	public List<apartment> getApartmentByName(String name) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.getApartmentByName(name);
	}

	@Transactional
	public apartment getApartmentById(int id) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.getApartmentById(id);
	}

	@Transactional
	public apartment getApartmentByAccount(String account) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.getApartmentByAccount(account);
	}

	@Transactional
	public boolean updateApartment(apartment apartment) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.updateApartment(apartment);
	}

	@Transactional
	public List<apartment> getApartments(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return apartmentDaoImp.getPartOfApartments(pagenum, pagesize);
	}

}
