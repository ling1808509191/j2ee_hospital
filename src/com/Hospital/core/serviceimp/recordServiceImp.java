package com.Hospital.core.serviceimp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital.core.daoimp.recordDaoImp;
import com.Hospital.core.entity.record;
import com.Hospital.core.service.recordService;
@Service
public class recordServiceImp implements recordService {
@Autowired
private recordDaoImp recordDaoImp;
@Transactional
	public record getRecordById(int id) {
		// TODO Auto-generated method stub
		return recordDaoImp.getRecordById(id);
	}

@Transactional
	public List<record> getRecordsByPatienId(int id, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return recordDaoImp.getRecordsByPatienId(id, pagenum, pagesize);
	}

	@Transactional
	public List<record> getRecordsByDoctorId(int id, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return getRecordsByDoctorId(id, pagenum, pagesize);
	}

	@Transactional
	public List<record> getRecordsByDoctorAndPatien(int d_id, int p_id,
			int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		return recordDaoImp.getRecordsByDoctorAndPatien(d_id, p_id, pagenum, pagesize);
	}

	@Transactional
	public List<record> getRecordsByDoctorAndDate(Date start, Date end, int d_id) {
		// TODO Auto-generated method stub
		return recordDaoImp.getRecordsByDoctorAndDate(start, end, d_id);	
	}

	@Transactional
	public boolean saveRecord(record record) {
		// TODO Auto-generated method stub
		return recordDaoImp.saveRecord(record);
	}

	@Transactional
	public boolean updateRecord(record record) {
		// TODO Auto-generated method stub
		return recordDaoImp.updateRecord(record);
	}

}
