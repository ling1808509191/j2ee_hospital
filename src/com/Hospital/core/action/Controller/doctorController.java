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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String addPlan(@RequestBody Map mappp) throws ParseException{
		Map map = new HashMap();
		Gson gson=new Gson();
		int d_id = (int)mappp.get("d_id");
		String date = (String)mappp.get("date");
		JSONObject jo=new JSONObject(mappp.toString());
		JSONArray time=jo.getJSONArray("time");
		JSONArray p_num=jo.getJSONArray("p_num");
		List<Integer> t = new ArrayList<Integer>();
		List<Byte> p = new ArrayList<Byte>();
		for(int i = 0; i < time.length(); i++){
			t.add(time.getInt(i));
			p.add((byte)p_num.getInt(i));
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
			Boolean r = dmi.addPlan(d_id, date, t, p);
			map.clear();
			map.put("result", r);
			return gson.toJson(map);
		}
	}
	
	private List<Byte> add(byte b) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/getPlanByDoctorId", method = RequestMethod.GET)
	@ResponseBody
	public String getgetPlanByDoctorId(HttpServletRequest request,HttpServletResponse response)  {
		Map map = new HashMap();
		Gson gson=new Gson();
		int d_id = -1;
		try {
			d_id = Integer.parseInt(request.getParameter("d_id"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String n_date = df.format(new Date());
		Date date2 =new Date();
		try {
			date2 = df.parse(n_date);
		} catch (Exception e) {
			
			System.out.println("date2 = "+date2);
			// TODO: handle exception
		}
		
		List<plan> list = null;
		try {
			 list = dmi.getPlanByDoctorId(d_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("d_id=  "+d_id);
		}
		Date date1 = new Date();
		for(plan p : list) {
			p.setDoctor(null);
			
			try {
				 date1 = df.parse(p.getDate());
			} catch (Exception e) {
				
				System.out.println("p.getdate = "+p.getDate());
			 // TODO: handle exception
			}
			
			int days = (int)((date1.getTime() - date2.getTime())/86400000);
			if(days > 7 || days < 0) {
				list.remove(p);
			}
		}
		map.clear();
		map.put("content", list);
		String result= "";
		try {
			 result= gson.toJson(map);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("result = "+result);
			System.err.println("map: content="+list);
		}
		
		return result;
	}
	
	@RequestMapping(value="/getPlanByDate", method = RequestMethod.GET)
	@ResponseBody
	public String getPlanByDate(HttpServletRequest request,HttpServletResponse response) {
		Map map = new HashMap();
		Gson gson=new Gson();
		String date = request.getParameter("date");
		System.out.println("date = "+date);
		List<plan> list = dmi.getPlanByDate(date);
		map.clear();
		map.put("content", list);
		return gson.toJson(map);
	}
}
