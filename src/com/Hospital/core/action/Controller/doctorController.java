package com.Hospital.core.action.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

import com.Hospital.core.entity.plan;
import com.Hospital.core.modeleimp.DoctorModelImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/doctor")
public class doctorController {
	@Autowired
	private DoctorModelImp dmi;
	
	@RequestMapping(value="/addPlan", method = RequestMethod.POST)
	@ResponseBody
	public String addPlan(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		Map map = new HashMap();
		Gson gson=new Gson();
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		String date = request.getParameter("date");
//		int time = Integer.parseInt(request.getParameter("time"));
//		byte p_num = Byte.parseByte(request.getParameter("p_num"));
		List<Integer> time = new ArrayList<Integer>();
		List<Byte> p_num = new ArrayList<Byte>();
		List<String> values_time = Arrays.asList(request.getParameterValues("time"));
		for(String v : values_time) {
			time.add(Integer.parseInt(v));
		}
		List<String> values_p_num = Arrays.asList(request.getParameterValues("p_num"));
		for(String v : values_p_num) {
			p_num.add(Byte.parseByte(v));
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = df.parse(date);
		String n_date = df.format(new Date());
		Date date2 = df.parse(n_date);
		int days = (int)((date1.getTime() - date2.getTime())/86400000);

		
		if(days < 8 || days >14) {
			Boolean r = false;
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		} else {
			Boolean r = dmi.addPlan(d_id, date, time, p_num);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
	}
	
	@RequestMapping(value="/getPlanByDoctorId", method = RequestMethod.GET)
	@ResponseBody
	public String getgetPlanByDoctorId(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		Map map = new HashMap();
		Gson gson=new Gson();
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String n_date = df.format(new Date());
		Date date2 = df.parse(n_date);
		List<plan> list = dmi.getPlanByDoctorId(d_id);
		for(plan p : list) {
			Date date1 = df.parse(p.getDate());
			int days = (int)((date1.getTime() - date2.getTime())/86400000);
			if(days > 7 || days < 0) {
				list.remove(p);
			}
		}
		map.clear();
		map.put("content", list);
		return gson.toJson(map);
	}
	
	@RequestMapping(value="/getPlanByDate", method = RequestMethod.GET)
	@ResponseBody
	public String getPlanByDate(HttpServletRequest request,HttpServletResponse response) {
		Map map = new HashMap();
		Gson gson=new Gson();
		String date = request.getParameter("date");
		List<plan> list = dmi.getPlanByDate(date);
		map.clear();
		map.put("content", list);
		return gson.toJson(map);
	}
}
