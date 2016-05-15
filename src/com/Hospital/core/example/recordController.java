package com.Hospital.core.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.record.recordmodel;
/*
 * @Controller标签标示这个是一个控制器 可以接受路由映射
 * requestmapping 标示URL映射
 */
@Controller
@RequestMapping(value="/numbergame", produces = {"application/json;charset=UTF-8"})
public class recordController {
	
	@Autowired
	private recordmodel remodel;
     @ResponseBody
     /*
      * 
      */
	@RequestMapping(value="/getAllRecord")
     /*这个requestmapping标示这个方法对 /Hospital/numbergame/getAllRecord 这个url进行处理
      * request是一个请求对象
      * 若不使用@responsebody标签 ，则返回的string被解释为 string.jsp 会返回对应jsp文件
      * 一个函数的成员类需要包含对应的get和set方法，这个类中的recordmodel类就需要get和set方法
      * 使用时不需要new
      */
	public String getAllRecord(HttpServletRequest request){
    	       
    	       String result=remodel.handleRequestGetAll();
    	      
    	       return result;
      }
     @ResponseBody
     @RequestMapping(value="/postRecord")
     public String postRecord(HttpServletRequest request){
    	 String username=request.getParameter("username");
	       String record=request.getParameter("record"); 
	       String result=remodel.handlPostRecord(username, Integer.parseInt(record));
    	 return result;
     }
     @ResponseBody
     @RequestMapping(value="/getRecords")
     public String getRecords(HttpServletRequest request){
    	  String result=remodel.handleWebService();
    	  return result;
    	  
    	 
     }
     
     
}
