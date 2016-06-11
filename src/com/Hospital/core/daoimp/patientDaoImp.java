package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Hospital.core.dao.patientDao;
import com.Hospital.core.entity.patient;
@Component
public class patientDaoImp implements patientDao {
	@Autowired
private SessionFactory SessionFactory;
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Override
	public boolean savePatient(patient patient) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(patient);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in patienDaoImp savepatien");
			return false;
		}
		return true;
	}

	@Override
	public boolean delPatient(patient patient) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(patient);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in patienDaoImp delpatien");
			return false;
		}
		return false;
	}

	@Override
	public boolean updatePatient(patient patient) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(patient);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in patienDaoImp updatepatien");
			return false;
		}
		return true;
	}

	@Override
	public List<patient> getPatientsByname(String name) {
		// TODO Auto-generated method stub
		String hql="from patient p where p.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<patient> result=query.list();
		if(result.size()==0)
			return null;
		return result;
	}

	@Override
	public patient getPatientById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
				patient patient=(patient)SessionFactory.getCurrentSession().get(patient.class, id);
				return patient;
	}

	@Override
	public patient getPatientByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from patient p where p.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<patient> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public List<patient> getAllPatients() {
		// TODO Auto-generated method stub
		String hql="from patient  ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		
		List<patient> result=query.list();
		if(result.size()==0)
			return null;
		return result;
	}

	@Override
	public List<patient> getPartOfPatients(int pagenum, int pagesize) {
		if(pagenum<=0)
			pagenum=1;
		// TODO Auto-generated method stub
		String hql="from patient ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<patient> result=query.list();
		return result;
	}

	
}
