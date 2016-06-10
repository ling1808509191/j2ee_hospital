package com.Hospital.core.action.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hospital.core.modeleimp.DoctorModelImp;
import com.Hospital.core.modeleimp.apartmentModelImp;
import com.Hospital.core.modeleimp.exampleModelImp;
import com.Hospital.core.modeleimp.hospitalModelImp;
import com.Hospital.core.modeleimp.managerModelImp;
import com.Hospital.core.modeleimp.patientModelImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/test")
public class testController {
	@Autowired
	private managerModelImp mmi;
	@Autowired
	private	hospitalModelImp hmi;
	@Autowired
	private	apartmentModelImp ami;
	@Autowired
	private	DoctorModelImp dmi;
	@Autowired
	private	patientModelImp pmi;
	@Autowired
	private exampleModelImp exampleModelImp;
	
	@RequestMapping(value="/register")
	@ResponseBody
	public String testt(HttpServletRequest request,HttpServletResponse response){
		 Gson gson=new Gson();
		 System.out.println("fuck");
		return gson.toJson(exampleModelImp.getBeans());
			
	}	
@RequestMapping(value="/login")
@ResponseBody
public String test(HttpServletRequest request,HttpServletResponse response){
	 Gson gson=new Gson();
	 System.out.println("get request in test");
	return gson.toJson(exampleModelImp.getBeans());
		
}




}
