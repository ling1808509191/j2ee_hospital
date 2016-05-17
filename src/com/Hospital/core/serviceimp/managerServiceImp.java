package com.Hospital.core.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.managerDaoImp;
import com.Hospital.core.entity.manager;
import com.Hospital.core.service.managerService;

public class managerServiceImp implements managerService{
	@Autowired
private managerDaoImp managerDaoImp;
	@Transactional
	public boolean saveManager(manager manager) {
		// TODO Auto-generated method stub
		return managerDaoImp.saveManager(manager);
	}

	@Transactional
	public boolean updateManager(manager manager) {
		// TODO Auto-generated method stub
		return managerDaoImp.updateManager(manager);
	}

	@Transactional
	public manager getManagerByaccount(String account) {
		// TODO Auto-generated method stub
		return managerDaoImp.getManagerByaccount(account);
	}

	@Transactional
	public manager getManagerByname(String name) {
		// TODO Auto-generated method stub
		return managerDaoImp.getManagerByname(name);
	}

	@Transactional
	public List<manager> getManagers() {
		// TODO Auto-generated method stub
		return managerDaoImp.getAllManagers();
	}

	@Transactional
	public boolean delManager(manager manager) {
		// TODO Auto-generated method stub
		return managerDaoImp.delManager(manager);
	}

	@Transactional
	public manager getManagerById(int id) {
		// TODO Auto-generated method stub
		return managerDaoImp.getManagerById(id);
	}

	@Transactional
	public List<manager> getManagers(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return managerDaoImp.getPartOfManagers(pagenum, pagesize);
	}

}
