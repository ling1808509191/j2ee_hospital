package com.Hospital.core.service;

import java.util.Date;
import java.util.List;

import com.Hospital.core.entity.record;

public interface recordService {
	record getRecordById(int id);
	List<record> getRecordsByPatienId(int id,int pagenum,int pagesize);
	List<record> getRecordsByDoctorId(int id,int pagenum,int pagesize);
	List<record> getRecordsByDoctorAndPatien(int d_id,int p_id,int pagenum,int pagesize);
	List<record> getRecordsByDoctorAndDate(Date start,Date end,int d_id);
	//List<record> getRecords(int pagenum,int pagesize);
	boolean saveRecord(record record);
	boolean updateRecord(record record);
}
