package com.Hospital.core.action.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hospital.core.entity.hospital;
import com.Hospital.core.modeleimp.managerModelImp;
import com.google.gson.Gson;
@Controller
@RequestMapping(value="/manager")
public class managerController {
	@Autowired
	private managerModelImp mmi;

	@RequestMapping(value="/addHospital", method = RequestMethod.POST)
	@ResponseBody
	public String addHospital(@RequestBody Map mappp){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 String account=(String)mappp.get("account");
		 String name=(String)mappp.get("name");
		 String password=(String)mappp.get("password");
		 System.out.println("account="+account+"  name="+name+"   password="+password);
		 Boolean r = mmi.createHospital(account, name, password);
		 map.clear();
		 map.put("result", r);
//		 System.out.println(request.getInputStream());
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/updateHospital", method = RequestMethod.POST)
	@ResponseBody
	public String updateHospital(@RequestBody Map mappp){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int h_id = (int)(mappp.get("h_id"));
		 String account = (String)mappp.get("account");
		 String name = (String)mappp.get("name");
		 String password = (String)mappp.get("password");
		 Boolean r = mmi.updateHospital(h_id, account, name, password); 
		 map.clear();
		 map.put("result", r);
		 return gson.toJson(map);			
	}
	
	@RequestMapping(value="/getHospitalByPage", method = RequestMethod.GET)
	@ResponseBody
	public String getHospitalByPage(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		 int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		 List<hospital> list = mmi.getHospitals(pagenum, pagesize);
		 map.clear();
		 map.put("content", list);
		 return gson.toJson(map);			
	}
	
	@RequestMapping(value="/delHospitalById", method = RequestMethod.GET)
	@ResponseBody
	public String delHospitalById(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int h_id = Integer.parseInt(request.getParameter("h_id"));
		 Boolean r = mmi.delHospitalById(h_id);
		 map.clear();
		 map.put("result", r);
		 return gson.toJson(map);		
	}
}
