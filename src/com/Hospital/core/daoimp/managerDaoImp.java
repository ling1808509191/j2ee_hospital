package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.dao.managerDao;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.manager;
@Component
public class managerDaoImp implements managerDao {
	@Autowired
private SessionFactory SessionFactory;
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	@Override
	public boolean saveManager(manager manager) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(manager);
			
		} catch (Exception e) {
			System.out.println("catch exception in managerdaoimp savemanager");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateManager(manager manager) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(manager);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in managerdaoimp updatemanager");
			return false;
		}
		return true;
	}

	@Override
	public manager getManagerByaccount(String account) {
		// TODO Auto-generated method stub
		String hql="from manager m where m.account=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		List<manager> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public manager getManagerByname(String name) {
		// TODO Auto-generated method stub
		String hql="from manager m where m.name=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<manager> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public List<manager> getAllManagers() {
		// TODO Auto-generated method stub
		String hql="from manager m ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		
		List<manager> result=query.list();
		if(result.size()==0)
			return null;
		return result;
	}

	@Override
	public boolean delManager(manager manager) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(manager);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in managerdaoimp delmanager");
			return false;
		}
		return true;
	}

	@Override
	public manager getManagerById(int id) {
		// TODO Auto-generated method stub
		String hql="from manager m where m.id=? ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<manager> result=query.list();
		if(result.size()==0)
			return null;
		return result.get(0);
	}

	@Override
	public List<manager> getPartOfManagers(int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		if(pagenum<=0)
			pagenum=1;
		String hql="from manager ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<manager> result=query.list();
		return result;
	}

}
