package com.Hospital.core.dao;

import java.util.Date;

import com.Hospital.core.entity.plan;

public interface planDao {
boolean savePlan(plan plan);
boolean updatePlan(plan plan);
boolean delPlan(plan plan);
plan getPlanById(int id);
plan getPlanByDate(String date);
plan getPlanByDoctorId(int id);
}
