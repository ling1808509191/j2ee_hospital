package com.Hospital.core.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Hospital.core.entity.plan;
import com.Hospital.core.serviceimp.doctorServiceImp;

public interface doctorModel {
	public boolean login(String account, String password);
	public boolean addPlan(int d_id, String date, int time, byte p_num);
	public List<plan> getPlanByDoctorId(int d_id);
	public List<plan> getPlanByDate(String date);
}
