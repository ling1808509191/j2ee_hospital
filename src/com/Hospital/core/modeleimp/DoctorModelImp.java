package com.Hospital.core.modeleimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.entity.doctor;
import com.Hospital.core.entity.plan;
import com.Hospital.core.model.doctorModel;
import com.Hospital.core.serviceimp.doctorServiceImp;
import com.Hospital.core.serviceimp.planServiceImp;
@Component
public class DoctorModelImp implements doctorModel {
	@Autowired
	private	doctorServiceImp dsi;
	@Autowired
	private	planServiceImp psi;

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		doctor d = dsi.getDoctorByAccount(account);
		if(password.equals(d.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addPlan(int d_id, String date, int time, byte p_num) {
		// TODO Auto-generated method stub
		doctor d = dsi.getDoctorById(d_id);
		plan p = new plan();
		p.setDate(date);
		p.setDoctor(d);
		
		switch(time) {
		case 1: p.setTime_1(p_num); break;
		case 2: p.setTime_2(p_num); break;
		case 3: p.setTime_3(p_num); break;
		case 4: p.setTime_4(p_num); break;
		case 5: p.setTime_5(p_num); break;
		case 6: p.setTime_6(p_num); break;
		case 7: p.setTime_7(p_num); break;
		case 8: p.setTime_8(p_num); break;
		case 9: p.setTime_9(p_num); break;
		case 10: p.setTime_10(p_num); break;
		case 11: p.setTime_11(p_num); break;
		case 12: p.setTime_12(p_num); break;
		case 13: p.setTime_13(p_num); break;
		case 14: p.setTime_14(p_num); break;
		case 15: p.setTime_15(p_num); break;
		default: p.setTime_16(p_num); break;
		}
		
		boolean r = psi.savePlan(p);
		
		return r;
	}

	@Override
	public List<plan> getPlanByDoctorId(int d_id) {
		// TODO Auto-generated method stub
		return psi.getPlanByDoctorId(d_id);
	}

	@Override
	public List<plan> getPlanByDate(String date) {
		// TODO Auto-generated method stub
		return psi.getPlanByDate(date);
	}

}
