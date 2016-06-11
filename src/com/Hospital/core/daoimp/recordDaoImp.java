package com.Hospital.core.daoimp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Hospital.core.dao.recordDao;
import com.Hospital.core.entity.plan;
import com.Hospital.core.entity.record;
@Component
public class recordDaoImp implements recordDao {
	@Autowired
    private SessionFactory SessionFactory;
	@Override
	public record getRecordById(int id) {
		// TODO Auto-generated method stub
		record record=(record)SessionFactory.getCurrentSession().get(record.class, id);
		return record;
	}

	


	@Override
	public List<record> getRecordsByPatienId(int id,int pagenum,int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.patient.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<record> result=query.list();
		return result;
	}




	@Override
	public List<record> getRecordsByDoctorId(int id, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.doctor.id=?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<record> result=query.list();
		return result;
	}


	@Override
	public List<record> getRecordsByDoctorAndPatien(int d_id, int p_id,
			int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		String hql="from record r where r.patient.id=? and r.doctor.id=?";
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




	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}




	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
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




	@Override
	public List<record> getRecordsByDoctorAndDate(Date start, Date end, int d_id) {
		// TODO Auto-generated method stub
		String hql="from record r where r.doctor.id=? and r.time_order between ? and ?";
		Query query=SessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, d_id);
		query.setDate(0, start);
		query.setDate(0, end);
		return query.list();
	}






	

}
