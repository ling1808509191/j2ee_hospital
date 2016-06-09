package com.Hospital.core.dao;

import java.util.Date;
import java.util.List;

import com.Hospital.core.entity.plan;

public interface planDao {
boolean savePlan(plan plan);
boolean updatePlan(plan plan);
boolean delPlan(plan plan);
plan getPlanById(int id);
List<plan> getPlanByDate(String date);
List<plan> getPlanByDoctorId(int id);
List<plan> getPartOfPlans(int pagenum,int pagesize);
}
