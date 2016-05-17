package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.apartment;

public interface apartmentService {
	boolean saveApartment(apartment apartment);
	boolean delApartment(apartment apartment);
	List<apartment> getApartments();
	List<apartment> getApartmentByName(String name);
	apartment getApartmentById(int id);
	apartment getApartmentByAccount(String account);
	boolean updateApartment(apartment apartment);
	List<apartment> getApartments(int pagenum,int pagesize);
}
