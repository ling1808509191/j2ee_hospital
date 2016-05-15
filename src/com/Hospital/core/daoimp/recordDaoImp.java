package com.Hospital.core.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Hospital.core.dao.recordDao;
import com.Hospital.core.entity.plan;
import com.Hospital.core.entity.record;

public class recordDaoImp implements recordDao {
private SessionFactory SessionFactory;
	@Override
	public record getRecordById(int id) {
		// TODO Auto-generated method stub
		String hql="from record r where r.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<record> result=query.list();
		return result.get(0);
	}

	


	@Override
	public List<record> getRecordsByPatienId(int id,int pagenum,int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.p_id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<record> result=query.list();
		return result;
	}




	@Override
	public List<record> getRecordsByDoctorId(int id, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.d_id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<record> result=query.list();
		return result;
	}


	@Override
	public List<record> getRecordsByDoctorAndPatien(int d_id, int p_id,
			int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.p_id=? and r.d_id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, p_id);
		query.setInteger(1, d_id);
		if(pagenum<=0)
			pagenum=1;
		query.setFirstResult((pagenum-1)*pagesize);
		query.setMaxResults(pagesize);
		List<record> result=query.list();
		return result;
	}




	@Override
	public boolean saveRecord(record record) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(record);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in recordDaoImp saverecord");
			return false;
		}
		return true;
	}




	@Override
	public boolean updateRecord(record record) {
		// TODO Auto-generated method stub
		try {
			SessionFactory.getCurrentSession().save(record);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch exception in recordDaoImp saverecord");
			return false;
		}
		return true;
	}






	

}
