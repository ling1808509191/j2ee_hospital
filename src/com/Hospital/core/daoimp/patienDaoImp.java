package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Hospital.core.dao.patienDao;
import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.patient;

public class patienDaoImp implements patienDao {
private SessionFactory SessionFactory;
	@Override
	public boolean savePatien(patient patient) {
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
	public boolean delPatien(patient patient) {
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
	public boolean updatePatien(patient patient) {
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
	public doctor getDoctorByname(String name) {
		// TODO Auto-generated method stub
		String hql="from doctor d where d.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<doctor> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="from doctor d where d.id=?";
				Query query=SessionFactory.getCurrentSession().createQuery(hql);
				query.setInteger(0, id);
				List<doctor> result=query.list();
				if(result.size()==0)
					return null;
				return result.get(0);
	}

	@Override
	public doctor getDoctorByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from doctor d where d.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<doctor> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public List<doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		String hql="from doctor d ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		
		List<doctor> result=query.list();
		if(result.size()==0)
			return null;
		return result;
	}

}
