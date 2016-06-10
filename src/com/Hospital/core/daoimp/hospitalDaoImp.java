package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.dao.hospitalDao;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.hospital;
@Component
public class hospitalDaoImp implements hospitalDao {
	@Autowired
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
		String hql="from hospital h where h.name=?";
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<hospital> result=query.list();
		
		return result.get(0);
	}

	@Transactional
	public hospital getHospitalbyId(int id) {
		// TODO Auto-generated method stub
		String hql="from hospital h where h.id=?";
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<hospital> result=query.list();
		
		return result.get(0);
	}

	@Transactional
	public hospital getHospitalByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from hospital h where h.account=?";
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<hospital> result=query.list();
		
		return result.get(0);
	}

	@Transactional
	public List<hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		String hql="from hospital h ";
		Query query = SessionFactory.getCurrentSession().createQuery(hql);
		
		List<hospital> result=query.list();
		
		return result;
	}

	@Transactional
	public boolean saveHospital(hospital hospital) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(hospital);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in hospitaldaoimp savehospital");
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delHospital(hospital hospital) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(hospital);
		} catch (Exception e) {
			System.out.println("catch exception in hospitaldaoimp delhospital");
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updateHospital(hospital hospital) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(hospital);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in hospitaldaoimp updatehospital");
			return false;
		}
		return true;
	}

	@Transactional
	public List<hospital> getPartOfHospitals(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		if(pagenum<=0)
			pagenum=1;
		String hql="from hospital ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<hospital> result=query.list();
		return result;
	}

}
