package com.Hospital.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.core.daoimp.managerDaoImp;
import com.Hospital.core.entity.manager;
@Service
public class testService {
	@Autowired
private managerDaoImp managerDaoImp;
	public List<manager> getAllManagers(){
		
		return managerDaoImp.getAllManagers();
		
	}
}
