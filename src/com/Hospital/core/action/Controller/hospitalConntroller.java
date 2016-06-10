package com.Hospital.core.action.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hospital.core.entity.apartment;
import com.Hospital.core.modeleimp.hospitalModelImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/hospital")
public class hospitalConntroller {
	@Autowired
	private hospitalModelImp hmi;
	
	
	
	@RequestMapping(value="/addApartment", method = RequestMethod.POST)
	@ResponseBody
	public String addApartment(@RequestBody Map mappp){
		 Map map = new HashMap();
		 Gson gson=new Gson();
		 int h_id = (int)(mappp.get("h_id"));
		 String account = (String)mappp.get("account");
		 String name = (String)mappp.get("name");
		 String password = (String)mappp.get("password");
		 Boolean r = hmi.createApartment(h_id, account, name, password);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/updateApartment", method = RequestMethod.POST)
	@ResponseBody
	public String updateApartment(@RequestBody Map mappp){
		 Map map = new HashMap();
		 
		 Gson gson=new Gson();
		 int a_id = (int)(mappp.get("a_id"));
		 String account = (String)mappp.get("account");
		 String name = (String)mappp.get("name");
		 String password = (String)mappp.get("password ");
		 Boolean r = hmi.updateApartment(a_id, account, name, password);
		 map.clear();
		 map.put("result", r);
		 return gson.toJson(map);			
	}
	
	@RequestMapping(value="/getApartmentByPage",method = RequestMethod.GET)
	@ResponseBody
	public String getApartmentByPage(HttpServletRequest request,HttpServletResponse response){
	 Map map = new HashMap();
		System.out.println("hospitalConntroller.g");
		 Gson gson=new Gson();
		 int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		 int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		 List<apartment> list = hmi.getApartments(pagenum, pagesize);
		 map.clear();
		 map.put("content", list);
		 return gson.toJson(map);			
	}
	
	@RequestMapping(value="/delApartmentById", method = RequestMethod.GET)
	@ResponseBody
	public String delApartmentById(HttpServletRequest request,HttpServletResponse response){
		 Map map = new HashMap();
		 Gson gson=new Gson();
		 int a_id = Integer.parseInt(request.getParameter("a_id"));
		 Boolean r = hmi.delApartmentById(a_id);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);			
	}
}
