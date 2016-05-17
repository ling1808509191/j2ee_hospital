package com.Hospital.core.service;

import java.util.List;

import com.Hospital.core.entity.manager;

public interface managerService {
	 boolean saveManager(manager manager);
	 boolean updateManager(manager manager);
	 manager getManagerByaccount(String account);
	 manager getManagerByname(String name);
	 List<manager> getManagers();
	 boolean delManager(manager manager);
	manager getManagerById(int id);
	List<manager> getManagers(int pagenum,int pagesize);

}
