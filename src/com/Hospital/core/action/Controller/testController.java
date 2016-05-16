package com.Hospital.core.action.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hospital.core.service.testService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="")
public class testController {
	@Autowired
	private testService testService;
@RequestMapping(value="/test")
@ResponseBody
public String test(HttpServletRequest request,HttpServletResponse response){
	 Gson gson=new Gson();
	return gson.toJson(testService.getAllManagers());
	
	
}
}
