package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Hospital.core.dao.doctorDao;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.doctor;

public class doctorDaoImp implements doctorDao {
private SessionFactory SessionFactory;
	@Override
	public doctor getDoctorByname(String name) {
		// TODO Auto-generated method stub
		String hql="from doctor a where a.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<doctor> result=query.list();
		return result.get(0);
	}

	@Override
	public doctor getDoctorByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from doctor a where a.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<doctor> result=query.list();
		return result.get(0);
	}

	@Override
	public doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		String hql="from doctor a where a.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<doctor> result=query.list();
		return result.get(0);
	}

	@Override
	public List<doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		String hql="from doctor a ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		
		List<doctor> result=query.list();
		return result;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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
