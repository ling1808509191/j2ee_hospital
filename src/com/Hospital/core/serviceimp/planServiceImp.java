package com.Hospital.core.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.planDaoImp;
import com.Hospital.core.entity.plan;
import com.Hospital.core.service.planService;
@Service
public class planServiceImp implements planService {
@Autowired
private planDaoImp planDaoImp;
@Transactional
	public boolean savePlan(plan plan) {
		// TODO Auto-generated method stub
		return planDaoImp.savePlan(plan);
	}

@Transactional
	public boolean updatePlan(plan plan) {
		// TODO Auto-generated method stub
		return planDaoImp.updatePlan(plan);
	}

@Override
	public boolean delPlan(plan plan) {
		// TODO Auto-generated method stub
		return planDaoImp.delPlan(plan);
	}

@Transactional
	public plan getPlanById(int id) {
		// TODO Auto-generated method stub
		return planDaoImp.getPlanById(id);
	}

@Transactional
	public List<plan> getPlanByDate(String date) {
		// TODO Auto-generated method stub
		return planDaoImp.getPlanByDate(date);
	}

@Transactional
	public List<plan> getPlanByDoctorId(int id) {
		// TODO Auto-generated method stub
		return planDaoImp.getPlanByDoctorId(id);
	}

@Transactional
	public List<plan> getPartOfPlans(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return planDaoImp.getPartOfPlans(pagenum, pagesize);
	}

}
