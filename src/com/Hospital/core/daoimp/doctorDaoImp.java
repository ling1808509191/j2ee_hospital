package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.dao.doctorDao;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.doctor;
@Component
public class doctorDaoImp implements doctorDao {
	@Autowired
private SessionFactory SessionFactory;
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Transactional
	public List<doctor> getDoctorByname(String name) {
		// TODO Auto-generated method stub
		String hql="from doctor a where a.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<doctor> result=query.list();
		return result;
	}

	@Transactional
	public doctor getDoctorByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from doctor a where a.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<doctor> result=query.list();
		return result.get(0);
	}

	@Transactional
	public doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		
		doctor doctor=(doctor)SessionFactory.getCurrentSession().get(doctor.class, id);
		
		return doctor;
	}

	@Transactional
	public List<doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		String hql="from doctor a ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		
		List<doctor> result=query.list();
		return result;
	}

	@Transactional
	public boolean delDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(doctor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in doctorDaoImp deldoctor");
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updateDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(doctor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in doctorDaoImp updatedoctor");
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveDoctor(doctor doctor) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(doctor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in doctorDaoImp savedoctor");
			return false;
		}
		return true;
	}

	@Transactional
	public List<doctor> getPartOfDoctors(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		if(pagenum<=0)
			pagenum=1;
		String hql="from doctor ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<doctor> result=query.list();
		return result;
	}

}
