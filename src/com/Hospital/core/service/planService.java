package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.plan;

public interface planService {
	boolean savePlan(plan plan);
	boolean updatePlan(plan plan);
	boolean delPlan(plan plan);
	plan getPlanById(int id);
	List<plan> getPlanByDate(String date);
	List<plan>getPlanByDoctorId(int id);
	List<plan> getPartOfPlans(int pagenum,int pagesize);
	plan getPlansByDoctorIdAndDate(int d_id,String date);
}
