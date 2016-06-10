package com.Hospital.core.model;

public interface patientModel {
	public boolean register(String account, String name, String password);
	public boolean login(String account, String password);
}
