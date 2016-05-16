package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Hospital.core.dao.apartmentDao;
import com.Hospital.core.entity.apartment;
@Component
public class apartmentDaoImp implements apartmentDao {
	@Autowired
private SessionFactory SessionFactory;
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Override
	public boolean saveApartment(apartment apartment) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(apartment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in apartmentdaoimp saveapartment");
			return false;
		}
		return true;
	}

	@Override
	public boolean delApartment(apartment apartment) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(apartment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in apartmentdaoimp delapartment");
			return false;
		}
		return true;
	}

	@Override
	public List<apartment> getAllApartments() {
		// TODO Auto-generated method stub
		String hql="from apartment a";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<apartment> getApartmentByName(String name) {
		// TODO Auto-generated method stub
		String hql="from apartment a where a.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<apartment> result=query.list();
		return result;
	}

	@Override
	public apartment getApartmentById(int id) {
		// TODO Auto-generated method stub
		String hql="from apartment a where a.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<apartment> result=query.list();
		return result.get(0);
	}

	@Override
	public apartment getApartmentByAccount(String account) {
		// TODO Auto-generated method stub
		String hql="from apartment a where a.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<apartment> result=query.list();
		return result.get(0);
	}

	@Override
	public boolean updateApartment(apartment apartment) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(apartment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in apartmentdaoimp updateapartment");
			return false;
		}
		return true;
	}

	@Override
	public List<apartment> getPartOfApartments(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		if(pagenum<=0)
			pagenum=1;
		String hql="from apartment ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<apartment> result=query.list();
		return result;
	}

}
