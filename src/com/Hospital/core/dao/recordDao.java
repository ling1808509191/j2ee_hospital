package com.Hospital.core.dao;

import java.util.List;

import com.Hospital.core.entity.record;

public interface recordDao {
record getRecordById(int id);
record getRecordByDoctorId(int id);
List<record> getRecordsByPatienId(int id);
List<record> getRecordsByDoctorId(int id);
List<record> getRecordsByDoctorAndPatien(int d_id,int p_id);
boolean saveRecord(record record);
boolean updateRecord(record record);

}
