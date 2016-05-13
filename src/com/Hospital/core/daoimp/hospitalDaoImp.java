package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Hospital.core.dao.hospitalDao;
import com.Hospital.core.entity.hospital;

public class hospitalDaoImp implements hospitalDao {
private SessionFactory SessionFactory;

	public SessionFactory getSessionFactory() {
	return SessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	SessionFactory = sessionFactory;
}

	@Override
	public hospital getHospitalbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public hospital getHospitalbyId(int id) {
		// TODO Auto-generated method stub
		String hql="from hospital h where h.id=?";
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<hospital> result=query.list();
		
		return result.get(0);
	}

	@Override
	public hospital getHospitalByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHospital(hospital hospital) {
		// TODO Auto-generated method stub
		return false;
	}

}
