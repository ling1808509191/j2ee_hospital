package com.Hospital.core.action.Controller;

import java.util.ArrayList;
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

import com.Hospital.core.entity.doctor;
import com.Hospital.core.modeleimp.apartmentModelImp;
import com.Hospital.core.res.part_of_doctor;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/apartment")
public class apartmentController {
	@Autowired
	private apartmentModelImp ami;
	
	@RequestMapping(value="/addDoctor", method = RequestMethod.POST)
	@ResponseBody
	public String addDoctor(@RequestBody Map mappp){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int a_id = (int)(mappp.get("a_id"));
		 int h_id = (int)(mappp.get("h_id"));
		 String account = (String)mappp.get("account");
		 String name = (String)mappp.get("name");
		 String password = (String)mappp.get("password");
		 int level = (int)(mappp.get("level"));
		 int price = (int)(mappp.get("price"));
		 String description = (String)mappp.get("description");
		 String imageUrl = (String)mappp.get("imageUrl");
		 Boolean r = ami.createDoctor(a_id, h_id, account, name, password, level, price, description, imageUrl);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/updateDoctor", method = RequestMethod.POST)
	@ResponseBody
	public String updateDoctor(@RequestBody Map mappp){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int a_id = (int)(mappp.get("a_id"));
		 int d_id = (int)(mappp.get("d_id"));
		 String account = (String)mappp.get("account");
		 String name = (String)mappp.get("name");
		 String password = (String)mappp.get("password ");
		 int level = (int)(mappp.get("level"));
		 int price = (int)(mappp.get("price"));
		 String description = (String)mappp.get("description");
		 String imageUrl = (String)mappp.get("imageUrl");
		 Boolean r = ami.updateDoctor(a_id, d_id, account, name, password, level, price, description, imageUrl);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);	
	}
	
	@RequestMapping(value="/getDoctorByPage", method = RequestMethod.GET)
	@ResponseBody
	public String getDoctorByPage(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		 int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		 List<doctor> list = ami.getDoctors(pagenum, pagesize);
		 List<part_of_doctor> list_d = new ArrayList<part_of_doctor>();
		 for(doctor d : list) {
			 part_of_doctor pod = new part_of_doctor();
			 pod.setD_id(d.getId());
			 pod.setName(d.getName());
			 pod.setDescription(d.getDetel());
			 pod.setImageUrl(d.getImgurl());
			 pod.setLevel(d.getLevel());
			 list_d.add(pod);
		 }
		 map.clear();
		 map.put("content", list_d);
		return gson.toJson(map);			
	}
	
	@RequestMapping(value="/delDoctorById", method = RequestMethod.GET)
	@ResponseBody
	public String delDoctorById(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap();
		 Gson gson=new Gson();
		 int d_id = Integer.parseInt(request.getParameter("d_id"));
		 Boolean r =ami.delDoctorById(d_id);
		 map.clear();
		 map.put("result", r);
		return gson.toJson(map);		
	}
}
