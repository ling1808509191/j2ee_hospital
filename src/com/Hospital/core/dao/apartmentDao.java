package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.apartment;

public interface apartmentDao {
boolean saveApartment(apartment apartment);
boolean delApartment(apartment apartment);
List<apartment> getAllApartments();
apartment getApartmentByName(String name);
apartment getApartmentById(int id);
apartment getApartmentByAccount(String account);
boolean updateApartment(apartment apartment);
}
