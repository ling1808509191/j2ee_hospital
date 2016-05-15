package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Hospital.core.dao.planDao;
import com.Hospital.core.entity.apartment;
import com.Hospital.core.entity.plan;

public class planDaoImp implements planDao {
private SessionFactory SessionFactory;
	@Override
	public boolean savePlan(plan plan) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(plan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in planDaoImp saveplan");
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePlan(plan plan) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().update(plan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in planDaoImp updateplan");
			return false;
		}
		return true;
	}

	@Override
	public boolean delPlan(plan plan) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().delete(plan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in planDaoImp delplan");
			return false;
		}
		return true;
	}

	@Override
	public plan getPlanById(int id) {
		// TODO Auto-generated method stub
		String hql="from plan p where p.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<plan> result=query.list();
		return result.get(0);
	}

	@Override
	public plan getPlanByDate(String date) {
		// TODO Auto-generated method stub
		String hql="from plan p where p.date=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, date);
		List<plan> result=query.list();
		return result.get(0);
	}

	@Override
	public plan getPlanByDoctorId(int id) {
		// TODO Auto-generated method stub
		String hql="from plan p where p.d_id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<plan> result=query.list();
		return result.get(0);
	}

	@Override
	public List<plan> getPartOfPlans(int pagenum, int pagesize) {
		if(pagenum<=0)
			pagenum=1;
		// TODO Auto-generated method stub
		String hql="from plan ";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
	query.setFirstResult((pagenum-1)*pagesize);
	query.setMaxResults(pagesize);
		List<plan> result=query.list();
		return result;
	}

}
