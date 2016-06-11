package com.Hospital.core.action.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import com.Hospital.core.serviceimp.doctorServiceImp;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/doctor")
public class doctorController {
	@Autowired
	private DoctorModelImp dmi;
	@Autowired
	private doctorServiceImp dsi;
	
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
	public String getPlanByDoctorId(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		Map map = new HashMap();
		Gson gson=new Gson();
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		System.out.println(d_id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String n_date = df.format(new Date());
		Date date2 = df.parse(n_date);
		System.out.println(d_id + " " + n_date);
		List<plan> list = dmi.getPlanByDoctorId(d_id);
		List<plan> list_tmp = new ArrayList<plan>(list);
 		System.out.println(list.size());
		int size = list.size();
		for(int i = 0; i < size; i++) {
			plan p = list_tmp.get(i);
			Date date1 = df.parse(p.getDate());
			System.out.println(date1);
			System.out.println(date2);
			int days = (int)((date1.getTime() - date2.getTime())/86400000);
			System.out.println(days);
			if(days > 7 || days < 0) {
				System.out.println(list);
				list.remove(p);
				System.out.println(list);
			}
		}
		int flag = 0;
		for(int j = 0; j < 7; j++) {
			Calendar cal = Calendar.getInstance(); 
	        cal.setTime(date2); 
	        cal.add(Calendar.DAY_OF_MONTH, j);
	        if(list != null) {
	        	for(plan p: list) {
		        	if(p.getDate().equals(df.format(cal.getTime()))){
		        		flag = 1;
		        		break;
		        	}
		        	else {
		        		continue;
		        	}
		        }
		        if(flag == 0) {
		        	plan pl = new plan();
		        	pl.setDate(df.format(cal.getTime()));
		        	pl.setDoctor(dsi.getDoctorById(d_id));
		        	list.add(pl);
		        }
	        }
	        else {
	        	plan pl = new plan();
	        	pl.setDate(df.format(cal.getTime()));
	        	pl.setDoctor(dsi.getDoctorById(d_id));
	        	list.add(pl);
	        }
	        
		}
		Collections.sort(list, new Comparator<plan>() { 
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			public int compare(plan o1, plan o2) {
				// TODO Auto-generated method stub
				Date d1 = null, d2 = null;
				try { 
                    d1 = df.parse(o1.getDate()); 
                } catch (ParseException e) { 
                    e.printStackTrace(); 
                }
				try { 
	                d2 = df.parse(o2.getDate()); 
	            } catch (ParseException e) { 
	                e.printStackTrace(); 
	            }
				if(null == d1 || null == d2) { 
                    return 0; 
                }
				return  d1.compareTo(d2);
			} 
        });
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
		System.out.println(date);
		System.out.println(list);
		map.clear();
		map.put("content", list);
		return gson.toJson(map);
	}
}
