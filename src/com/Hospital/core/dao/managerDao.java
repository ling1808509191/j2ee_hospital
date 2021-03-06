package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.manager;

public interface managerDao {
 boolean saveManager(manager manager);
 boolean updateManager(manager manager);
 manager getManagerByaccount(String account);
 manager getManagerByname(String name);
 List<manager> getAllManagers();
 boolean delManager(manager manager);
manager getManagerById(int id);
List<manager> getPartOfManagers(int pagenum,int pagesize);

}
