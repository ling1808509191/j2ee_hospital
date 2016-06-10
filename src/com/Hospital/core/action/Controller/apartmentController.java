package com.Hospital.core.action.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hospital.core.entity.doctor;
import com.Hospital.core.modeleimp.apartmentModelImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/apartment")
public class apartmentController {
	@Autowired
	private apartmentModelImp ami;
	
	private Map map = new HashMap();
	
	@RequestMapping(value="/addDoctor", method = RequestMethod.POST)
	@ResponseBody
	public String addDoctor(HttpServletRequest request,HttpServletResponse response){
		 Gson gson=new Gson();
		 int a_id = Integer.parseInt(request.getParameter("a_id"));
		 int h_id = Integer.parseInt(request.getParameter("h_id"));
		 String account = request.getParameter("account");
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 int level = Integer.parseInt(request.getParameter("level"));
		 int price = Integer.parseInt(request.getParameter("price"));
		 Boolean r = ami.createDoctor(a_id, h_id, account, name, password, level, price);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/updateDoctor", method = RequestMethod.POST)
	@ResponseBody
	public String updateDoctor(HttpServletRequest request,HttpServletResponse response){
		 Gson gson=new Gson();
		 int a_id = Integer.parseInt(request.getParameter("a_id"));
		 int d_id = Integer.parseInt(request.getParameter("d_id"));
		 String account = request.getParameter("account");
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 int level = Integer.parseInt(request.getParameter("level"));
		 int price = Integer.parseInt(request.getParameter("price"));
		 Boolean r = ami.updateDoctor(a_id, d_id, account, name, password, level, price);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);	
	}
	
	@RequestMapping(value="/getDoctorByPage", method = RequestMethod.GET)
	@ResponseBody
	public String getDoctorByPage(HttpServletRequest request,HttpServletResponse response){
		 Gson gson=new Gson();
		 int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		 int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		 List<doctor> list = ami.getDoctors(pagenum, pagesize);
		 map.clear();
		 map.put("content", list);
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/delDoctorById", method = RequestMethod.GET)
	@ResponseBody
	public String delDoctorById(HttpServletRequest request,HttpServletResponse response){
		 Gson gson=new Gson();
		 int d_id = Integer.parseInt(request.getParameter("d_id"));
		 Boolean r =ami.delDoctorById(d_id);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);		
	}
}
