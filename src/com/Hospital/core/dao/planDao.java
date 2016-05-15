package com.Hospital.core.dao;

import java.util.Date;
import java.util.List;

import com.Hospital.core.entity.plan;

public interface planDao {
boolean savePlan(plan plan);
boolean updatePlan(plan plan);
boolean delPlan(plan plan);
plan getPlanById(int id);
plan getPlanByDate(String date);
plan getPlanByDoctorId(int id);
List<plan> getPartOfPlans(int pagenum,int pagesize);
}
