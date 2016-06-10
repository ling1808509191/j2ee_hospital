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
import com.Hospital.core.modeleimp.hospitalModelImp;
import com.Hospital.core.modeleimp.managerModelImp;
import com.Hospital.core.modeleimp.patientModelImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="")
public class indexController {
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
	
	private Map map = new HashMap();
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response){
		Gson gson=new Gson();
		int type = Integer.parseInt(request.getParameter("type"));
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		switch(type) {
		case 1: {
			Boolean r = mmi.login(account, password);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
		case 2: {
			Boolean r = hmi.login(account, password);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
		case 3: {
			Boolean r = ami.login(account, password);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
		case 4: {
			Boolean r = dmi.login(account, password);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
		default: {
			Boolean r = pmi.login(account, password);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
		}
	}
	
//	@RequestMapping(value="/register", method = RequestMethod.POST)
//	@ResponseBody
//	public String register(HttpServletRequest request,HttpServletResponse response){
//		Gson gson=new Gson();
//		String account = request.getParameter("account");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		Boolean r = pmi.register(account, name, password);
//		map.clear();
//		map.put("result", r);
//		return gson.toJson(map);
//		
//	}
}
